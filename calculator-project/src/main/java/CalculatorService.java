import io.*;

import java.util.Optional;
import java.util.regex.Pattern;

public class CalculatorService<T extends Number> implements Runnable{
    static final int VIEW = 1, CALCULATE = 2, EXIT = 3;
    private Input input;
    private Output output;
    Calculator<T> calculator;

    @Override
    public void run() {
        while(true){
            output.menu();
            switch(input.selectMenu()){
                case VIEW:
                    output.history(calculator.getHistory());
                    break;
                case CALCULATE:
                    output.result(calculator.calculate(input.operation()));
                    break;
                case EXIT:
                    output.exit();
                    return;
                default:
                    output.inputError();
                    break;
            }
        }
    }


}

