package org.rent.model.enums;

public enum State {

	UP ("Uttra Pradesh"),
    MP ("Madya Pradesh"),
    Karnataka ("Karnataka");

    private final String name;       

    private State(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}