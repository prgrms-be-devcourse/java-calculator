package com.bona.javacalculator;

import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.service.*;

public class Calculator implements Runnable{
    CalculateService calculateService = new CalculateService();
    InquiryService inquiryService = new InquiryService();
    private final Console console = new Console();
    @Override
    public void run() {
        boolean isRun = true;

        while(isRun){
            String input = console.input("1. 조회 2. 계산 3.종료");
            int number = parse(input);
            Option option = Option.valueOf(number);

            if (option == null) {
                continue;
            }

            switch (option) {
                case INQUIRY:
                    inquiryService.inquiry();
                    break;
                case CALCULATE:
                    calculateService.calculate();
                    break;
                case EXIT:
                    isRun = false;
                    break;
                default:
                    console.printMessage("잘못된 입력입니다");
                    break;
            }
        }
    }

    private int parse(String input) {
        if (input.isBlank()) {
            return 3; // EXIT
        }
        if (!CheckService.isNumber(input)) {
            return 0; //INVALID_INPUT
        }
        return Integer.parseInt(input);
    }

}
