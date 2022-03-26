package com.kimhunki.java.calculator.engine;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.ResultRepository;
import com.kimhunki.java.calculator.io.Input;
import com.kimhunki.java.calculator.io.Output;
import com.kimhunki.java.calculator.model.Calculate;
import com.kimhunki.java.calculator.model.CalculateStrategy;
import com.kimhunki.java.calculator.model.Query;
import com.kimhunki.java.calculator.model.QueryStrategy;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class Selector implements Runnable
{
    Console console;

    @Override
    public void run()
    {
        CalculateStrategy calculate = new Calculate(console);// 2번 계산 기능을 위한 인스턴스
        QueryStrategy query = new Query(console);
        ResultRepository resultRepository = new ResultRepository(new ArrayList<>());
        while(true)
        {
            System.out.println("1. 조회\n2. 계산\n\n");
            String selectString =  console.input("선택 : ");
            if(parse(selectString))
            {
                selectModel(selectString,calculate,query,resultRepository,console);
            }
            else
                console.inputError();

        }
    }

    private boolean parse(String selectString)
    {
        if(selectString.equals("1") || selectString.equals("2"))
            return true;
        return false;
    }

    private void selectModel(String selectString,CalculateStrategy calculate, QueryStrategy query,ResultRepository resultRepository,Console console)
    {
        if (selectString.equals("1")){
            calculate.calculate(resultRepository);
        }

        else if(selectString.equals("2"))
            if (resultRepository.getResultList().size() > 0)
                query.printResult(resultRepository);
    }
}
