package com.project.java.engine.converter;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StringExpressionConverter<T> {
    List<T> list;

    public String convert() {
        StringBuffer sb = new StringBuffer();
        for (T t : list) {
            sb.append(t).append(" ");
        }
        sb.append("= ");
        return sb.toString();
    }
}
