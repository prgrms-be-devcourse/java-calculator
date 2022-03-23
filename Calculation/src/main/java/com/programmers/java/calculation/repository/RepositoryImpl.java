package com.programmers.java.calculation.repository;


import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    private final List<String> list = new ArrayList<>();

    @Override
    public void save(String  o) {
        list.add(o);

    }

    @Override
    public void findAll() {
        for (String a : list) {
            System.out.println(a);
        }
    }
}
