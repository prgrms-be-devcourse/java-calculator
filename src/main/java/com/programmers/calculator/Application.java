package com.programmers.calculator;

import com.programmers.calculator.controller.ConsoleController;
import com.programmers.calculator.domain.CalculateHistory;
import com.programmers.calculator.repository.InMemoryRepository;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.service.CalculatorService;
import com.programmers.calculator.view.ConsoleView;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Repository<Long, CalculateHistory> repository = new InMemoryRepository();
        CalculatorService calculatorService = new CalculatorService(repository);
        ConsoleController controller = new ConsoleController(calculatorService);

        ConsoleView view = new ConsoleView(controller, new Scanner(System.in));
        Calculator calculator = new Calculator(view);

        calculator.run();
    }

}
