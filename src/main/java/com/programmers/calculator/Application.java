package com.programmers.calculator;

import com.programmers.calculator.controller.ConsoleController;
import com.programmers.calculator.controller.Controller;
import com.programmers.calculator.domain.CalculateHistory;
import com.programmers.calculator.repository.InMemoryRepository;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.service.CalculatorService;
import com.programmers.calculator.view.ConsoleView;
import com.programmers.calculator.view.View;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Repository<Long, CalculateHistory> repository = new InMemoryRepository();
        CalculatorService calculatorService = new CalculatorService(repository);
        Controller controller = new ConsoleController(calculatorService);

        View view = new ConsoleView(controller, new Scanner(System.in));
        Calculator calculator = new Calculator(view);

        calculator.run();
    }

}
