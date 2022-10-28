package com.project.java.engine.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SaveFormat {
    private int id;
    private String expression;

    @Override
    public String toString() {
        return id + ". " + expression + '\n';
    }
}
