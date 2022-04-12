package com.programmers.mission.model;

import java.util.Optional;

public enum ExpressionProperty {
	OPERATOR, OPERAND;

	public static ExpressionProperty getProperty(String letter) {
		Optional<OperatorType> operatorType = OperatorType.getValue(letter);

		if (operatorType.isEmpty()) {
			return OPERAND;
		}

		return OPERATOR;
	}
}
