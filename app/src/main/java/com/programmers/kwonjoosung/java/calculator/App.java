package com.programmers.kwonjoosung.java.calculator;

import com.programmers.kwonjoosung.java.calculator.controller.CalculatorController;
import com.programmers.kwonjoosung.java.calculator.io.Console;
import com.programmers.kwonjoosung.java.calculator.service.BasicCalculator;
import com.programmers.kwonjoosung.java.calculator.utils.BasicParser;
import com.programmers.kwonjoosung.java.calculator.repository.Memory;
import com.programmers.kwonjoosung.java.calculator.repository.HashMapCache;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    public void run() { // 빌더 패턴과 DI 고려해보기

        Memory memory = new Memory();
        Console console = new Console();
        BasicCalculator calculator = new BasicCalculator();
        HashMapCache cache = new HashMapCache();
        BasicParser parser = new BasicParser();

        // 어플리케이션 조합 및 실행
        CalculatorController.builder()
                .HISTORY(memory)
                .CACHE(cache)
                .CALCULATOR(calculator)
                .parser(parser)
                .IN(console)
                .OUT(console)
                .build()
                .run();
    }
}
