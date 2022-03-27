package com.programmers.calculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.programmers.calculator.engine.Calculator;
import com.programmers.calculator.io.Console;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		new Calculator(new Console(), new Console()).run();

	}

}
