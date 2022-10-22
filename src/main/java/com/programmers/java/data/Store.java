package com.programmers.java.data;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Store {
    private List<Result> store;

    public Store() {
        this.store = new ArrayList<Result>();
    }

    public Result getResult(String s){
        return null;
    }

    public boolean contain(String expression) {
        List<String> expressions = store.stream().map(Result::getExp).toList();
        return expressions.contains(expression);
    }

    public void save(Result res) {
        store.add(res);
    }
}
