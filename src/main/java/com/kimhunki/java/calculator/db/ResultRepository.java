package com.kimhunki.java.calculator.db;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ResultRepository
{
    private List<String> resultList;

    void addResult(String result)
    {
        resultList.add(result);
    }

}
