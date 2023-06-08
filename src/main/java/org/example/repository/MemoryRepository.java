package org.example.repository;

import java.util.*;

public class MemoryRepository implements Repository{
    private List<String> saveList = new ArrayList<>();

    @Override
    public void save(String str) {
        saveList.add(str);
    }

    @Override
    public String[] findAll() {
        String[] resultArr = saveList.toArray(new String[saveList.size()]);
        return resultArr;
    }
}
