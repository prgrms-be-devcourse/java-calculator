
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

    public App(Console console, HistoryEntity historyEntity, Calculator calculator) {
        this.input = console;
        this.output = console;
        this.historyEntity = historyEntity;
        this.calculator = calculator;
    }

    @Override
    public void run(){

        while (true) {

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
                case HISTORY:
                    if (!(output.showResultHistory(historyEntity.getHistory()))) output.historyEmptyError();
                    break;
                case CALCULATE:
                    System.out.print("계산식을 입력해주세요 : ");

                    String inputString = null;

                    try {
                        inputString = input.inputString();

                        int result = calculator.cal(inputString);

                        output.printResult(result);

                        historyEntity.addHistory(inputString,result);

                    } catch (Exception e) {
                        output.inputEmptyError("수식을 입력해주세요!");
                        break;
                    }

            }
        }
    }

}
