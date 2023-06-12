
import io.Input;
import io.Output;
import model.Calculator;
import model.History;
import option.Option;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사용자가 옵션을 선택할 수 있습니다.
//선택한 옵션에 맞게 switch 문으로 해당 옵션에 맞는 메소드를 호출합니다.
public class Index implements Runnable{
    private Input input;
    private Output output;
    private History history;
    private Calculator calculator;

    public Index(Console console, History history, Calculator calculator) {
        this.input = console;
        this.output = console;
        this.history = history;
        this.calculator = calculator;
    }

    @Override
    public void run(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            output.ShowOptions();

            Option select = input.selectOption();

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
                        output.inputEmptyError("수식을 입력해주세요!");
                        break;
                    }

            }
        }
    }

}
