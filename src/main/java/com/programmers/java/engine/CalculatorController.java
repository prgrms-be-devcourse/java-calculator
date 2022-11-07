package com.programmers.java.engine;

import com.programmers.java.engine.calculator.Calculator;
import com.programmers.java.engine.io.IOController;
import com.programmers.java.engine.repository.HistoryRepository;
import com.programmers.java.engine.util.Menu;
import com.programmers.java.engine.util.translator.Translator;

public class CalculatorController implements Runnable {
    private final IOController ioController;
    private final Calculator calculator;
    private final Translator translator;
    private final HistoryRepository historyRepository;
    private boolean isExit = false;

    public CalculatorController(IOController ioController, Calculator calculator, Translator translator, HistoryRepository historyRepository) {
        this.ioController = ioController;
        this.calculator = calculator;
        this.translator = translator;
        this.historyRepository = historyRepository;
    }

    @Override
    public void run() {
        while (!isExit) {
            try {
                Menu.GUIDE.run(this);
                Menu.findMenu(ioController.read()).run(this);
            } catch (Exception e) {
                ioController.print(e.getMessage());
            }
        }
    }

    public IOController getIoController() {
        return ioController;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public Translator getTranslator() {
        return translator;
    }

    public HistoryRepository getHistoryRepository() {
        return historyRepository;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }
}
