package service;

import io.Input;
import io.Output;
import lombok.AllArgsConstructor;
import model.Option;


@AllArgsConstructor
public class ServiceImpl implements Runnable {
    private final Input input;
    private final Output output;
    private final CalculatorService calculatorService;

    /**
    * @Method : run
    * @Description : 계산기 실행
    * @Parameter :
    * @Return : void
    **/
    @Override
    public void run() {
        while (true) {
            output.printOption();
            try {
                String ops = input.readLine();
                Option parse = Option.parse(ops);
                parse.chooseOption(calculatorService,parse);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
