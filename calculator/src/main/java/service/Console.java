package service;

import io.Input;
import lombok.AllArgsConstructor;
import model.Option;
import util.GuideMessage;


@AllArgsConstructor
public class Console implements Runnable {
    private final Input input;
    private final Calculator calculatorService;

    /**
     * @Method : run
     * @Description : 계산기 실행
     * @Parameter :
     * @Return : void
     **/
    @Override
    public void run() {
        while (true) {
            System.out.print(GuideMessage.INPUT_MENU.getMessage());
            try {
                String option = input.readLine();
                Option parse = Option.parse(option);
                parse.chooseOption(calculatorService, parse);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
