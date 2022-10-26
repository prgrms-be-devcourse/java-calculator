package com.calculator;

import com.calculator.repository.MapRepository;
import com.calculator.common.Calculator;
import com.calculator.io.Console;

public class Application {


    public static void main(String[] args) {
        Console console = new Console();
        MapRepository mapRepository = new MapRepository();

        Calculator.builder()
                .input(console)
                .output(console)
                .repository(mapRepository)
                .build()
                .run();

    }
}
