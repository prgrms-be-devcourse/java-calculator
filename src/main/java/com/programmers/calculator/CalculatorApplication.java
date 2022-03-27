package com.programmers.calculator;

import com.programmers.calculator.engine.Calculator;
import com.programmers.calculator.io.Console;

public class CalculatorApplication {

	public static void main(String[] args) {
		new Calculator(new Console(), new Console());

	}

}
