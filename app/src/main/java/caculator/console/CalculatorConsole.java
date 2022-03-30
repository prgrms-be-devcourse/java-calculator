package caculator.console;

import caculator.engine.Calculator;
import caculator.io.CalculatorIO;
import caculator.io.IO;

public class CalculatorConsole implements Console {
    private static final int HISTORY = 1;
    private static final int CALCULATOR = 2;
    private IO io;
    private Calculator calculator;

    public CalculatorConsole() {
        this.io = new CalculatorIO();
        this.calculator = new Calculator();
    }

    public static void main(String[] args) {
        Console calculatorConsole = new CalculatorConsole();

        while (true) {
            calculatorConsole.start();
        }
    }

    @Override
    public void start() {
        io.print("1.조회\n2.계산");
        try {
            int menu = io.getNum();
            switch (menu) {
                case HISTORY:
                    calculator.showHistory();
                    break;
                case CALCULATOR:
                    StringBuilder formula = io.getLineWithNoSpaces();
                    if (calculator.isFormula(formula)) {
                        Float result = calculator.calculate(formula);
                        calculator.saveEquation(formula, result);
                        io.print(result);
                    }
                    break;
            }
        }
        catch (Exception e) {
            io.print(e.getMessage());
        }
    }
}
