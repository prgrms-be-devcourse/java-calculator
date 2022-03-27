package com.programmers.calculator.engine;

import java.math.BigDecimal;

public enum Operator {
	PLUS("+") {
		@Override
		public Value calculate(Value x, Value y) {
			return Value.valueOf(x.getValue().add(y.getValue()).toString());
		}
	},
	MINUS("-") {
		@Override
		public Value calculate(Value x, Value y) {
			return Value.valueOf(x.getValue().add(y.getValue().negate()).toString());
		}
	},
	MULTIPLY("*") {
		@Override
		public Value calculate(Value x, Value y) {
			return Value.valueOf(x.getValue().multiply(y.getValue()).toString());
		}
	},
	DIVIDE("%") {
		@Override
		public Value calculate(Value x, Value y) {
			if (y.equals(Value.valueOf("0"))) {
				throw new IllegalArgumentException("0으로 나눌 수 없습니다!");
			}

			return Value.valueOf(x.getValue().divide(y.getValue()).toString());
		}
	};

	private String op;

	Operator(String op) {
		this.op = op;
	}

	public abstract Value calculate(Value x, Value y);

}
