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
                chooseOption(parse);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
    * @Method : chooseOption
    * @Description : 메뉴 선택
    * @Parameter : Option
    * @Return : void
    **/
    void chooseOption(Option parse) {
        if (parse.equals(Option.INQUIRY)) calculatorService.getResults();
        else if (parse.equals(Option.CALCULATE)) calculatorService.input();
        else if (parse.equals(Option.EXIT)) System.exit(0);

        /* 자바8 버전: switch문 Enum 에러 발생
        switch (parse) {
            case INQUIRY: calculatorService.getResults();
            case CALCULATE: calculatorService.calculate();
            case EXIT: System.exit(0);
        } */
    }
}
