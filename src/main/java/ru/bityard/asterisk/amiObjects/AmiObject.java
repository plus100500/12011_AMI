package ru.bityard.asterisk.amiObjects;

import java.util.List;

public abstract class AmiObject {
    private List<String> unresolve;

    public List<String> getUnresolve() {
        return unresolve;
    }

    public void setUnresolve(List<String> unresolve) {
        this.unresolve = unresolve;
    }

    @Override
    public String toString() {
        return "AmiObject{" +
                "unresolve=" + unresolve +
                '}';
    }
}
