package com.programmers.java.engine.service;

import static com.programmers.java.engine.utils.Function.*;

import java.util.Stack;

public class CalculationService {

	public Long calculate(String[] postFixFormula) {
		Stack<Long> numbers = new Stack<>();

		for (String num : postFixFormula) {
			if (!isStrDigit(num)) {
				Long number1 = numbers.pop();
				Long number2 = numbers.pop();

				calcArithmetic(number2, number1, num, numbers);
			} else {
				numbers.push(Long.parseLong(num));
			}
		}

		return numbers.pop();
	}

	public void calcArithmetic(Long a, Long b, String str, Stack<Long> s) {
		switch (str) {
			case "+" : {
				s.push(a + b);
				break;
			}
			case "-" : {
				s.push(a - b);
				break;
			}
			case "/" : {
				s.push(a / b);
				break;
			}
			case "*" : {
				s.push(a * b);
				break;
			}
		}
	}
}