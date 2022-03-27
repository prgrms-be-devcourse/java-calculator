package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.ResultRepository;
import com.kimhunki.java.calculator.strategy.QueryStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Query implements QueryStrategy
{
    Console console;

    @Override
    public void printResult(ResultRepository resultRepository)
    {
        for(int i=0; i<resultRepository.getResultList().size(); i++)
            console.output(resultRepository.getResultList().get(i));
    }


}
