package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.ResultRepository;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class Calculate implements CalculateStrategy
{
    Console console;

    @Override
    public void calculate(ResultRepository resultRepository)
    {
        int result = 0;
        String expression =  console.input("");

        if(expression.isBlank() || !Character.isDigit(expression.charAt(expression.length()-1)))
        { // 그냥 엔터를 눌렀을 경우 or 마지막이 숫자가 아닌경우
            console.inputError();
            return;
        }


        List<String> expressionList = splitString(expression);

    }
    private List<String> splitString(String expression)
    {
        String[] splitString = expression.split(" ");
        List<String> arrayString = new ArrayList<>();
        Collections.addAll(arrayString, splitString);

        return arrayString;
    }

    private boolean isNumber(String num) // 숫자인지
    {
        for(int i=0; i<num.length(); i++)
        {
            if(!Character.isDigit(num.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    private boolean isSymbol(String symbol) // 부호인지
    {
        if (symbol.equals("+") ||symbol.equals("-") || symbol.equals("*") ||symbol.equals("/") )
            return true;
        return false;
    }



}
