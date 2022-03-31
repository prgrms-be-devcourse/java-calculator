package hyuk.controller;

import hyuk.model.RecordsDTO;
import hyuk.model.ResultDTO;
import hyuk.service.CalculatorService;
import hyuk.view.InputView;
import hyuk.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CalculatorService calculatorService;

    public CalculatorController(InputView inputView, OutputView outputView,
        CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        while (true) {
            outputView.printMenu();
            try {
                Menu menu = Menu.of(inputView.selectMenu());
                outputView.printEmptySpace();

                if (menu.isPrint()) {
                    RecordsDTO recordsDTO = calculatorService.printRecords();
                    outputView.printRecords(recordsDTO);
                    continue;
                }
                calculate();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
                continue;
            }
        }
    }

    private void calculate() {
        while (true) {
            try {
                String formula = inputView.inputFormula();

                ResultDTO resultDTO = calculatorService.calculate(formula);

                outputView.printResult(resultDTO);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }

}
