package com.programmers.engine.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ToString
public class CaculatorParseData {
    private final List<Object> list = new ArrayList<>();
    public void add(Double d){
        list.add(d);
    }
    public void add(Character c){
        list.add(c);
    }
    public Collection<?> getAllList(){
        return new ArrayList<>(list);
    }
}
