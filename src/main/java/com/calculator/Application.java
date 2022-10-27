package com.calculator;

import com.calculator.common.BaseException;
import com.calculator.common.ValidatorHandler;
import com.calculator.repository.MapRepository;
import com.calculator.common.Calculator;
import com.calculator.io.Console;

import java.io.IOException;

import static com.calculator.common.ExceptionStatus.*;

public class Application {

    public static void main(String[] args) {
        MapRepository mapRepository = new MapRepository();
        ValidatorHandler validatorHandler = new ValidatorHandler();
        Console console = new Console(validatorHandler);

        try {
            Calculator.builder()
                    .input(console)
                    .output(console)
                    .repository(mapRepository)
                    .validator(validatorHandler)
                    .build()
                    .run();
        } catch (BaseException e) {
            System.out.println(e.getStatus().getMessage());
        } catch (IOException e) {
            System.out.println(new BaseException(IO_ERROR).getMessage());
        }
    }
}