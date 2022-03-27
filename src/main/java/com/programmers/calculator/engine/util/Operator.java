package com.programmers.calculator.engine.util;

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

	/**
	 * 전략 열거 패턴
	 */
	public enum PriorityType {
		HIGH, LOW
	}

	Operator(String op, PriorityType type) {
		this.op = op;
		this.type = type;
	}

	/**
	 * 올바른 연산자를 입력했는지 판단하고 Operator를 반환하는 메서드
	 *
	 * @param op
	 * @return 입력된 값에 해당하는 operator
	 */
	public static Operator fineOperator(String op) {
		return Stream.of(Operator.values()).filter(o -> o.op.equals(op))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 연산자 입력입니다!"));
	}

	/**
	 * Operator의 우선순위를 반환하는 메서드
	 *
	 * @return 높은 우선순위면 HIGH, 낮은 우선순위면 LOW
	 */
	public PriorityType getPriorityType(){
		return this.type;
	}

	public abstract Value calculate(Value x, Value y);

}
