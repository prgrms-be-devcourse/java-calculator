package model;

import lombok.AllArgsConstructor;
import service.CalculatorService;

import java.util.Arrays;
import java.util.NoSuchElementException;

@AllArgsConstructor
public enum Option {
    INQUIRY(1), CALCULATE(2), EXIT(3);

    private final int select;

    /**
    * @Method : parse
    * @Description : input을 Option으로 바꾸는 메소드
    * @Parameter : [input]
    * @Return : Option
    **/
    public static Option parse(String input) {
        return Arrays.stream(Option.values())
                .filter(e -> e.select == toInt(input))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("1,2,3 중 선택해야 합니다"));
    }

    static int toInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해야 합니다.");
        }
    }

    /**
     * @Method : chooseOption
     * @Description : 메뉴 선택
     * @Parameter : [calculatorService,parse]
     * @Return : void
     **/
    public void chooseOption(CalculatorService calculatorService, Option parse) {
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
