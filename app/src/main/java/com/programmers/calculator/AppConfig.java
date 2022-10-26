package com.programmers.calculator;

import com.programmers.calculator.controller.Controller;
import com.programmers.calculator.model.ArithmeticOperationCalculator;
import com.programmers.calculator.model.Calculator;
import com.programmers.calculator.repository.MemoryResultRepository;
import com.programmers.calculator.repository.ResultRepository;
import com.programmers.calculator.view.Console;
import com.programmers.calculator.view.Input;
import com.programmers.calculator.view.Output;

public class AppConfig {
    public ResultRepository createResultRepository() {
        return new MemoryResultRepository();
    }

    public Input createInput() {
        return new Console();
    }

    public Output createOutput() {
        return new Console();
    }

    public Calculator createCalculator() {
        return new ArithmeticOperationCalculator();
    }

    public Controller createController() {
        return new Controller(createResultRepository(), createInput(), createOutput(), createCalculator());
    }
}
