package src;

import src.calculation.Calculator;
import src.io.Input;
import src.io.Output;
import src.log.Log;
import src.log.Logger;



public class CalculatorApp implements Runnable{
    private final Logger logger;
    private final Input input;
    private final Output output;

    public CalculatorApp(Logger logger, Input input, Output output) {
        this.logger = logger;
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
                output.printLog(logger.findAll());
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
        logger.save(Log.createLog(expression, answer));
    }

}
