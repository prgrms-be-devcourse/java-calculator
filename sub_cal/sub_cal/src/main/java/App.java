
import io.Input;
import io.Output;
import model.Calculator;
import model.HistoryEntity;
import option.Option;

import java.io.IOException;
import java.util.NoSuchElementException;

public class App implements Runnable {
    private final Input input;
    private final Output output;
    private final HistoryEntity historyEntity;
    private final Calculator calculator;
    private final boolean IS_RUNNING = true;

    public App(Console console, HistoryEntity historyEntity, Calculator calculator) {
        this.input = console;
        this.output = console;
        this.historyEntity = historyEntity;
        this.calculator = calculator;
    }

    @Override
    public void run() {

        while (IS_RUNNING) {

            output.printMenuList();
            Option select = null;
            select = input.selectOption();


            switch (select) {
                case HISTORY -> {
                    try {
                        output.showResultHistory(historyEntity.getHistory());
                    } catch (RuntimeException e) {
                        output.historyEmptyError();
                    }


                }
                case CALCULATE -> {
                    output.printInputExpressionMessage();
                    String inputString = input.inputExpression();

                    if (inputString == null) {
                        continue;
                    }

                    String result = calculator.calculate(inputString);

                    output.printResult(result);

                    historyEntity.addHistory(inputString, result);


                }
                case EXIT -> {
                    System.exit(0);
                }
            }
        }
    }

}
