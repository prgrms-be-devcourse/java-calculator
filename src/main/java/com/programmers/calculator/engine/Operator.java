package com.programmers.calculator.engine;

import java.util.stream.Stream;

public enum Operator {
	PLUS("+", PriorityType.LOW) {
		@Override
		public Value calculate(Value x, Value y) {
			return Value.valueOf(x.getValue().add(y.getValue()).toString());
		}
	},
	MINUS("-", PriorityType.LOW) {
		@Override
		public Value calculate(Value x, Value y) {
			return Value.valueOf(x.getValue().add(y.getValue().negate()).toString());
		}
	},
	MULTIPLY("*", PriorityType.HIGH) {
		@Override
		public Value calculate(Value x, Value y) {
			return Value.valueOf(x.getValue().multiply(y.getValue()).toString());
		}
	},
	DIVIDE("%", PriorityType.HIGH) {
		@Override
		public Value calculate(Value x, Value y) {
			if (y.equals(Value.valueOf("0"))) {
				throw new IllegalArgumentException("0으로 나눌 수 없습니다!");
			}

			return Value.valueOf(x.getValue().divide(y.getValue()).toString());
		}
	};

	private final String op;
	private final PriorityType type;

	public static enum PriorityType {
		HIGH, LOW
	}

	Operator(String op, PriorityType type) {
		this.op = op;
		this.type = type;
	}

	public abstract Value calculate(Value x, Value y);

	public static Operator fineOperator(String op) {
		return Stream.of(Operator.values()).filter(o -> o.op.equals(op))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입력입니다!"));
	}

	public boolean isHighPriority(){
		return this.type == PriorityType.HIGH;
	}


}
