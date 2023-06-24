
import io.Input;
import io.Output;
import model.Calculator;
import model.HistoryEntity;
import option.Option;

import java.io.IOException;
import java.util.NoSuchElementException;

public class App implements Runnable{
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
    public void run(){

        while (IS_RUNNING) {

            output.printMenuList();
            Option select = null;
            try{
             select = input.selectOption();
            } catch (NoSuchElementException e1){
                continue;
            } catch (IOException e2){
                continue;
            }

            switch (select) {
                case HISTORY -> {
                    if (!(output.showResultHistory(historyEntity.getHistory()))) output.historyEmptyError();
                    break;
                }
                case CALCULATE -> {

                    String inputString = null;

                    try {
                        inputString = input.inputExpression();

                        String result = calculator.calculate(inputString);

                        output.printResult(result);

                        historyEntity.addHistory(inputString,result);

                    } catch (Exception e) {
                        break;
                    }
                }
                case EXIT -> {
                    System.exit(0);
                }
            }
        }
    }

}
