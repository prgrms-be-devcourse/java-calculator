package com.programmers.calculator.engine;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 계산기에서 쓰일 값 객체
 */
public class Value {
	public static final Value ZERO = Value.valueOf(0);
	/**
	 * 실수 계산도 지원하기 위해 BigDecimal 사용
	 */
	private BigDecimal value;

	private Value() {
	}

	private Value(double val) {
		this.value = BigDecimal.valueOf(val);
	}

	private Value(String val) {
		this.value = new BigDecimal(val);
	}

	public BigDecimal getValue() {
		return value;
	}

	public static Value valueOf(int val) {
		Objects.requireNonNull(val);
		return new Value((double)val);
	}

	public static Value valueOf(double val) {
		Objects.requireNonNull(val);
		return new Value(val);
	}

	public static Value valueOf(String val) {
		Objects.requireNonNull(val);
		try {
			assertNumber(val);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

		return new Value(val);
	}

	private static void assertNumber(String val) {
		Double.parseDouble(val);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	/**
	 * BigDecimal끼리의 연산은 numeric value와 scale 모두를 비교(예시. 1 != 1.0)
	 * numeric value로만 비교하기 위해 BigDecimal의 compareTo 메서드를 사용
	 *
	 * @param o
	 * @return numeric value가 같으면 true, 다르면 false
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Value)) {
			return false;
		}
		Value val = (Value)o;
		return val.value.compareTo(this.value) == 0;
	}

	/**
	 * 나머지가 없으면 나머지를 제거한 수를, 나머지가 있으면 나머지까지 값을 반환하는 메서드
	 * @return value % 1 > 0 -> 나머지까지 반환
	 */
	@Override
	public String toString() {
		if (this.value.abs().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) > 0) {
			return String.valueOf(this.value.doubleValue());
		}
		return String.valueOf(this.value.intValue());
	}

}
