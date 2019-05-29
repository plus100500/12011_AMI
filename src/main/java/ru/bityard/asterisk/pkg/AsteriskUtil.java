package ru.bityard.asterisk.pkg;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;
import ru.bityard.asterisk.pkg.amiObjects.response.Follows;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
@Scope("prototype")
public class AsteriskUtil {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public String getNumber(String text) {
        if (text == null) return "";
        return text.replaceAll("\\D+", "");
    }

    public AmiObject getObject(String line) {

        AmiObject amiObject = null;

        String[] amiObjectName = line.split(": ");

        try {
            Class eventClass = Class.forName(
                    this.getClass().getPackage().getName()
                            .concat(".amiObjects.")
                            .concat(amiObjectName[0].toLowerCase())
                            .concat(".")
                            .concat(amiObjectName[1])
            );
            amiObject = (AmiObject) eventClass.newInstance();
        } catch (Exception e) {
//            log.error(e.toString());
        }
        return amiObject;
    }

    public void parseEvent(String line, AmiObject amiObject) {
//        log.debug("{}. {}",amiObject.getClass().getSimpleName(),line);
        String[] params = line.split(": ");

        // В response информация ввиде строк без стандарта
        if (params.length == 1) {
            params = new String[]{"line", line};
        }
        callSetter(amiObject, params[0], params[1]);
    }

    public void callSetter(Object obj, String fieldName, String value) {
//        log.debug("{} : {}",fieldName,value);
        if (obj != null && fieldName != null && value != null) {
            PropertyDescriptor pd;
            try {
                pd = getProperty(obj, fieldName);
//            log.debug("Method name is {}, PropertyType is {}", pd.getName(), pd.getPropertyType());
                if (pd != null && pd.getWriteMethod() != null && pd.getWriteMethod().getName() != null) {
                    if (pd.getWriteMethod().getName().equals("setLine"))
                        // Проверяю, если вносится в поле setLine, то нужна вся строка
                        pd.getWriteMethod().invoke(obj, fieldName + ": " + value);
                    else
                        pd.getWriteMethod().invoke(obj, value);
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public PropertyDescriptor getProperty(Object obj, String fieldName) {
        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
        } catch (IntrospectionException e) {
//            log.error(e.getMessage());
        } finally {
            if ((pd == null) && (obj.getClass().equals(Follows.class))) {
                try {
                    pd = new PropertyDescriptor("line", obj.getClass());
                } catch (IntrospectionException ie) {

                }
            }
        }
        return pd;
    }


    public String printList(List<?> objects) {
        if (objects != null && !objects.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object o : objects) {
                sb = sb.append("\r\n").append(o.toString());
            }
            return sb.toString();
        } else {
            return null;
        }
    }
}
