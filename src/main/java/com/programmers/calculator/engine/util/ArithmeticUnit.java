package com.programmers.calculator.engine.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArithmeticUnit {

	public static String calculate(String formula) {
		Objects.requireNonNull(formula);

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

		calculateByType(values, operators, Operator.PriorityType.HIGH);
		calculateByType(values, operators, Operator.PriorityType.LOW);

		return values.get(0).toString();
	}

	private static void calculateByType(List<Value> values, List<Operator> operators, Operator.PriorityType type) {
		assert values != null;
		assert operators != null;
		assert type != null;

		for (int i = operators.size() - 1; i >= 0; --i) {
			Operator op = operators.get(i);
			if (op.getPriorityType() == type) {
				operators.remove(i);
				Value first = values.remove(i + 1);
				Value second = values.remove(i);

				values.add(i, op.calculate(first, second));
			}
		}
	}

}
