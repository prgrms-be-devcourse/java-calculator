
import io.Input;
import io.Output;
import model.Calculator;
import model.History;
import option.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

import static global.ErrorMessage.EMPTY_INPUT_STRING;


public class Index implements Runnable{
    private final Input input;
    private final Output output;
        private final History history;
    private final Calculator calculator;

    public Index(Console console, History history, Calculator calculator) {
        this.input = console;
        this.output = console;
        this.history = history;
        this.calculator = calculator;
    }

    @Override
    public void run(){

        while (true) {

            output.ShowOptions();
            Option select = null;
            try{
             select = input.selectOption();
            } catch (NoSuchElementException e1){
                continue;
            } catch (IOException e2){
                continue;
            }

            //스위치 문을 통하여 옵션에 맞는 코드를 실행합니다
            switch (select) {
                case HISTORY:
                    if (!(output.showResultHistory(history.getHistory()))) output.historyEmptyError();
                    break;
                case CALCULATE:
                    System.out.print("계산식을 입력해주세요 : ");

                    String inputString = null;

                    try {
                        inputString = input.inputString();

                        int result = calculator.cal(inputString);

                        output.printResult(result);

                        history.addHistory(inputString,result);

                    } catch (Exception e) {
                        output.inputEmptyError(EMPTY_INPUT_STRING);
                        break;
                    }

            }
        }
    }

}
