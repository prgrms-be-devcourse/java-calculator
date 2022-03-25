package com.programmers.java.calculation;


import com.programmers.java.calculation.calculate.Calculate;
import com.programmers.java.calculation.calculate.CalculateBasicImpl;
import com.programmers.java.calculation.parse.*;
import com.programmers.java.calculation.repository.Repository;
import com.programmers.java.calculation.repository.RepositoryImpl;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Parsing parsing = new ParsingImpl();
        Validation validation = new ValidationAddDecimalImpl();
        Calculate calculate = new CalculateBasicImpl();
        Repository repository = new RepositoryImpl();

        Calculation calculation = new Calculation(parsing, validation, calculate);

        CalculationService calculationService = new CalculationService(console, console, repository, parsing, calculation);

        calculationService.run();


    }
}
