package controller;

import io.CalculatorInput;
import io.CalculatorOutput;
import model.calculation.Calculation;
import model.converter.Converter;
import model.vo.Menu;

public class CalculatorController implements Runnable {
    private final CalculatorInput input;
    private final CalculatorOutput output;
    private final Converter converter;
    private final Calculation calculation;

    public CalculatorController(CalculatorInput input, CalculatorOutput output, Converter converter, Calculation calculation) {
        this.input = input;
        this.output = output;
        this.converter = converter;
        this.calculation = calculation;
    }

    @Override
    public void run() {
        while (true) {
            output.printMenuMessage();
            selectMenu(input.menuInput());
        }
    }

    private void selectMenu(Menu menu) {
        switch (menu.getMenu()) {
            case 1 -> runRecordLogic();
            case 2 -> runCalculationLogic();
        }
    }

    private void runRecordLogic() {

    }

    private void runCalculationLogic() {

    }
}
