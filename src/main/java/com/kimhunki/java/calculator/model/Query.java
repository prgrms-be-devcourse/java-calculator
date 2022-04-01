package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.ResultRepository;
import com.kimhunki.java.calculator.io.Output;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Query
{
    Output output;

    public void printResult(ResultRepository resultRepository)
    {
        if (!resultRepository.getRepository().isEmpty())
        {
            for (String s : resultRepository.getRepository())
                output.output(s);

        } else output.emptyRepository();


    }
}
