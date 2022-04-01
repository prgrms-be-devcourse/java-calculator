package com.kimhunki.java.calculator.db;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MemoryResultRepository implements ResultRepository
{
    private List<String> resultList;
    @Override
    public void addResult(String result)
    {
        resultList.add(result);
    }

    @Override
    public List<String> getRepository()
    {
        return resultList;
    }


}
