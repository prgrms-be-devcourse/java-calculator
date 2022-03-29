package com.programmers.oop.type;

public enum ServiceType {
    LOOK_UP("1"), COMPUTE("2"),EXIT("-1");

    private String key;

    ServiceType(String key) {
        this.key = key;
    }

    public boolean isSameYn(String menu){
        return this.key.equals(menu);
    }
}
