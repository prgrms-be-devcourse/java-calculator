package calculator;

import calculator.engine.CalculatorEngine;
import calculator.handlermanager.CalculatorHandlerManager;
import calculator.handlermanager.ICalculatorHandlerManager;
import calculator.io.Input;
import calculator.io.Output;

public class Application {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        ICalculatorHandlerManager handlerManager = new CalculatorHandlerManager();
//        new Calculator(input, output, handlerManager).run();
        System.out.println(CalculatorEngine.DIV.equals("DIV"));
    }

}
