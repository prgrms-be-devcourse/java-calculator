package hyuk.controller;

import hyuk.calculator.Calculator;
import hyuk.entity.Log;
import hyuk.model.LogDTO;
import hyuk.model.Operands;
import hyuk.model.Operators;
import hyuk.model.Result;
import hyuk.repository.Repository;
import hyuk.view.InputView;
import hyuk.view.OutputView;
import java.util.Scanner;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final Repository repository;

    public CalculatorController(InputView inputView, OutputView outputView, Repository repository) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = new Calculator();
        this.repository = repository;
    }

    public void run() {
        while (true) {
            outputView.printMenu();

            try {
                String menu = inputView.selectMenu(new Scanner(System.in));
                if (menu.equals("1")) {
                    printLogs();
                    continue;
                }
                calculate();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private void calculate() {
        String formula = inputView.inputFormula(new Scanner(System.in));

        Operands operands = new Operands(formula);
        Operators operators = new Operators(formula);

        Result result = calculator.calculate(operands, operators);
        Log log = Log.createLog(operands, operators, result);

        repository.store(log);

        outputView.printResult(result);
    }

    private void printLogs() {
        LogDTO logDTO = new LogDTO(repository.getData());
        outputView.printLogs(logDTO);
    }
}
