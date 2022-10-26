package com.project.java.engine.converter;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StringExpressionConverter<T> {

    public String convert(List<T> list) {
        StringBuffer sb = new StringBuffer();
        for (T t : list) {
            sb.append(t).append(" ");
        }
        sb.append("= ");
        return sb.toString();
    }
}
