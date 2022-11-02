package com.programmers.java.engine;

import com.programmers.java.engine.calculator.Calculator;
import com.programmers.java.engine.io.IOController;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.repository.HistoryRepository;
import com.programmers.java.engine.util.Menu;
import com.programmers.java.engine.util.translator.Translator;

public class CalculatorController implements Runnable {
    private final IOController ioController;
    private final Calculator calculator;
    private final Translator translator;
    private final HistoryRepository historyRepository;

    public CalculatorController(IOController ioController, Calculator calculator, Translator translator, HistoryRepository historyRepository) {
        this.ioController = ioController;
        this.calculator = calculator;
        this.translator = translator;
        this.historyRepository = historyRepository;
    }

    @Override
    public void run() {
        boolean isExit = false;
        while (!isExit) {
            try {
                ioController.print(Menu.GUIDE.get());
                switch (Menu.findMenu(ioController.read())) {
                    case LOOKUP:
                        lookup();
                        break;
                    case COMPUTE:
                        calculate();
                        break;
                    case EXIT:
                        ioController.print("프로그램이 종료됩니다...\n");
                        isExit = true;
                        break;
                }

                if (isExit) break;
            } catch (Exception e) {
                ioController.print(e.getMessage());
            }
        }
    }


    private void lookup() {
        historyRepository.load().stream()
                .forEach(expression -> ioController.print(expression + "\n"));
    }

    private void calculate() {
        Expression expression = new Expression(ioController.read());
        Number result = calculator.calculate(translator.translate(expression));
        ioController.print(result + "\n");
        expression.add(" = " + result);
        historyRepository.save(expression);
    }
}
