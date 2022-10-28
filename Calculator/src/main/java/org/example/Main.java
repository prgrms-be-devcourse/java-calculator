package org.example;

import org.example.compute.Compute;
import org.example.compute.ComputeArithmeticOperation;
import org.example.io.ConsoleInput;
import org.example.io.ConsoleOutput;
import org.example.io.Input;
import org.example.io.Output;
import org.example.repository.ArrayListRepository;
import org.example.repository.Repository;
import org.example.validate.Validate;
import org.example.validate.ValidateExpression;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Input consoleInput = new ConsoleInput();
        Output consoleOutput = new ConsoleOutput();
        Validate validateExpression = new ValidateExpression();
        Compute computeArithmeticOperation = new ComputeArithmeticOperation();
        Repository arrayListRepository = new ArrayListRepository();


        new Calculator(consoleInput, consoleOutput, validateExpression, computeArithmeticOperation ,arrayListRepository).run();
    }
}