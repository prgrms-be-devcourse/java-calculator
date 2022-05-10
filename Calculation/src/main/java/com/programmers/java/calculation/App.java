package com.programmers.java.calculation;


import com.programmers.java.calculation.calculate.Calculate;
import com.programmers.java.calculation.calculate.CalculateBasicImpl;
import com.programmers.java.calculation.io.Input;
import com.programmers.java.calculation.io.Output;
import com.programmers.java.calculation.parse.*;
import com.programmers.java.calculation.repository.Repository;
import com.programmers.java.calculation.repository.RepositoryImpl;

public class App {
    public static void main(String[] args) {
        Input input = new Console();
        Output output = new Console();
        Parsing parsing = new ParsingImpl();
        Validation validation = new ValidationAddDecimalImpl();
        Calculate calculate = new CalculateBasicImpl();
        Repository repository = new RepositoryImpl();


        CalculationService calculationService =
                new CalculationService(input, output, repository, validation, parsing, calculate);

        calculationService.run();


    }
}
