package com.programmers.util;

public class IdGenerator {
    private int id;

    public IdGenerator() {
        id = 1;
    }

    public int generateId() {
        int nextId = id;
        id++;
        return nextId;
    }
}
