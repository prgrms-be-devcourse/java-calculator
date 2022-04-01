package com.kimhunki.java.calculator.engine;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.MemoryResultRepository;
import com.kimhunki.java.calculator.db.ResultRepository;
import com.kimhunki.java.calculator.io.Input;
import com.kimhunki.java.calculator.io.Output;
import com.kimhunki.java.calculator.model.InfixCalculator;
import com.kimhunki.java.calculator.model.Parser;
import com.kimhunki.java.calculator.model.RegularExpressionPattern;
import com.kimhunki.java.calculator.strategy.CalculatorStrategy;
import com.kimhunki.java.calculator.strategy.VerificationStrategy;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class Calculator
{
    private Input input;
    private Output output;
    private Parser parser;
    private VerificationStrategy verification;
    private CalculatorStrategy calculator;
    public void calculate(ResultRepository resultRepository)
    {

        String expression =  input.input("");
        if(!verification.verify(expression)){
            output.inputError();
            return;
        }


        if(expression.isBlank() || !Character.isDigit(expression.charAt(expression.length()-1)))
        { // 그냥 엔터를 눌렀을 경우 or 마지막이 숫자가 아닌경우
            output.inputError();
            return;
        }
        
        List<String> expressionList = parser.expressionParser(expression);
        String result = calculator.calculate(expressionList);
        String resultExpression = "";
        if(!result.equals("error"))
        {
            resultExpression = expression + " = " + result;
            System.out.println(resultExpression);
            resultRepository.addResult(resultExpression);
        }else{
            output.divError();
        }

    }

}
