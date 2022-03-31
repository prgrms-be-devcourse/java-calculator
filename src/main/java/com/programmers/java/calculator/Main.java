package com.programmers.java.calculator;

import com.programmers.java.calculator.utility.ArithmeticOperator;
import com.programmers.java.calculator.utility.ArithmeticPostfixConvertor;
import com.programmers.java.calculator.application.Calculator;
import com.programmers.java.calculator.utility.Operator;
import com.programmers.java.calculator.io.ConsoleInput;
import com.programmers.java.calculator.io.ConsoleOutput;
import com.programmers.java.calculator.io.Input;
import com.programmers.java.calculator.io.Output;
import com.programmers.java.calculator.repository.CalculatorRepository;
import com.programmers.java.calculator.repository.MemoryCalculatorRepository;
import com.programmers.java.calculator.utility.PostfixConvertor;

public class Main {
    public static void main(String[] args) {
        CalculatorRepository repository = new MemoryCalculatorRepository();
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Operator operator = new ArithmeticOperator();
        PostfixConvertor postfixConvertor = new ArithmeticPostfixConvertor();
        Calculator calculator = new Calculator(repository, input, output, operator, postfixConvertor);
        calculator.run();
    }
}
