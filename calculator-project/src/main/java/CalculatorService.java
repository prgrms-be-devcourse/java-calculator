import io.*;

public class CalculatorService implements Runnable{
    static final int VIEW = 1, CALCULATE = 2, EXIT = 3;
    private Input input;
    private Output output;
    private final Calculator calculator = new Calculator();

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

