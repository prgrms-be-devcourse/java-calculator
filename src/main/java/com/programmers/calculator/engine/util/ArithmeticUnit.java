package com.programmers.calculator.engine.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.programmers.calculator.engine.Operator;
import com.programmers.calculator.engine.Value;

public class ArithmeticUnit {

	public static String calculate(String formula) {
		List<Value> values = new ArrayList<>();
		List<Operator> operators = new ArrayList<>();
		String[] inputs = formula.trim().split(" ");
		for (int i = 0; i < inputs.length; ++i) {
			if (i % 2 == 0) {
				values.add(0, Value.valueOf(inputs[i]));
			} else {
				operators.add(0, Operator.fineOperator(inputs[i]));
			}
		}

		calc(values, operators);

		return values.get(0).toString();
	}

	private static void calc(List<Value> values, List<Operator> operators) {
		for (int i = operators.size() - 1; i >= 0; --i) {
			Operator op = operators.get(i);
			if (op.isHighPriority()) {
				operators.remove(i);
				Value first = values.remove(i + 1);
				Value second = values.remove(i);

				Value res = op.calculate(first, second);
				values.add(i, op.calculate(first, second));
			}
		}

		for (int i = operators.size() - 1; i >= 0; --i) {
			Operator op = operators.get(i);
			operators.remove(i);
			Value first = values.remove(i + 1);
			Value second = values.remove(i);
			Value res = op.calculate(first, second);

			values.add(op.calculate(first, second));
		}
	}

}
