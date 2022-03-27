package com.programmers.calculator.engine;

import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;

public class Calculator implements Runnable{
	private Input input;
	private Output output;

	public Calculator(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {

	}
}
