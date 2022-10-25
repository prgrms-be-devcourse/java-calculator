package org.example;

import org.example.io.ConsoleInput;
import org.example.io.ConsoleOutput;
import org.example.repository.HashMapRepository;
import org.example.repository.Repository;
import org.example.validate.ValidateExpression;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ValidateExpression validateExpression = new ValidateExpression();
        Repository repository = new HashMapRepository();


        new Calculator(consoleInput, consoleOutput, validateExpression, repository).calculate();
    }
}