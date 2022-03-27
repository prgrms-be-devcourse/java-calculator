package com.programmers.calculator.engine;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 계산기에서 쓰일 값 객체
 */
public class Value {
	/**
	 * 실수 계산도 지원하기 위해 BigDecimal 사용
	 */
	private BigDecimal value;

	private Value() {
	}

	private Value(double val) {
		this.value = BigDecimal.valueOf(val);
	}

	public static Value valueOf(int val) {
		Objects.requireNonNull(val);
		return new Value((double)val);
	}

	public static Value valueOf(double val) {
		Objects.requireNonNull(val);
		return new Value(val);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Value)) {
			return false;
		}
		Value val = (Value)o;
		return val.value.equals(this.value);
	}

	@Override
	public String toString() {
		if (this.value.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) > 0) {
			return String.valueOf(this.value.doubleValue());
		}
		return String.valueOf(this.value.intValue());
	}

	public static void main(String[] args) {
		System.out.println(Value.valueOf(5).toString());
		System.out.println(Value.valueOf(5.5).toString());
		System.out.println(Value.valueOf(5).toString());
	}

}
