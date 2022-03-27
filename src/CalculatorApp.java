package src;

import src.calculation.Calculator;
import src.io.Input;
import src.io.Output;
import src.log.Log;
import src.log.LogService;



public class CalculatorApp implements Runnable{
    private final LogService logService;
    private final Input input;
    private final Output output;

    public CalculatorApp(LogService logService, Input input, Output output) {
        this.logService = logService;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        while(true){

            output.printPrompt();

            int choice = 0;
            try{
                choice = input.getChoice();
            }catch (Exception e){
                output.printError(e.getMessage());
                continue;
            }

            if(choice == 1){
                //조회
                output.printLog(logService.findAll());
            }else if(choice == 2){
                //계산
                calculate();
            }
        }
    }


    /**
     * 계산 후 로그 남김
     */
    private void calculate() {
        String expression = input.getNextLine();
        String answer = null;
        try {
            answer = Calculator.calculate(expression);
        }catch (Exception e){
            output.printError(e.getMessage());
            return;
        }
        output.printAnswer(answer);
        logService.save(Log.createLog(expression, answer));
    }

}
