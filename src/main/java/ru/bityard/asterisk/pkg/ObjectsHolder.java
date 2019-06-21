package ru.bityard.asterisk.pkg;

import java.util.HashMap;
import java.util.Map;

class ObjectsHolder {

    private Map<String, Object> objectMap;

    public ObjectsHolder() {
        objectMap = new HashMap<>();
    }

    public Object get(String key) {
        return objectMap.getOrDefault(key, null);
    }
}
