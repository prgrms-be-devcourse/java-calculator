package com.programmers.java.data;

import lombok.Getter;

import java.util.*;

@Getter
public class Store {
    private List<Result> store;

    public Store() {
        this.store = new ArrayList<>();
    }

    public Optional<Result> getResult(String s){
        return store.stream()
                .filter(i -> i.getExp().equals(s))
                .findFirst();
    }

    public boolean contain(String expression) {
        List<String> expressions = store.stream().map(Result::getExp).toList();
        return expressions.contains(expression);
    }

    public void save(Result res) {
        store.add(res);
    }
}
