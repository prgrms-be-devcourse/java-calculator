package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.ResultRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculate implements CalculateStrategy
{
    Console console;

    @Override
    public void calculate(ResultRepository resultRepository)
    {
        String expression =  console.input("선택 : ");;

    }

    private boolean parse(String expression)
    {
        return false;
    }
}
