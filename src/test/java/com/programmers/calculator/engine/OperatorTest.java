package com.programmers.calculator.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.programmers.calculator.engine.util.Operator;
import com.programmers.calculator.engine.util.Value;

class OperatorTest {

	@DisplayName("1. 더하기(+)를 지원해야 한다")
	@Test
	public void support_plus() throws Exception {
		calculateUsingOperator(Value.valueOf(1), Value.valueOf(2), Operator.PLUS, Value.valueOf(3));
		calculateUsingOperator(Value.valueOf(1), Value.valueOf(2.5), Operator.PLUS,Value.valueOf(3.5));
		calculateUsingOperator(Value.valueOf(0), Value.valueOf(0), Operator.PLUS,Value.valueOf(0));
	}

	@DisplayName("2. 빼기(-)를 지원해야 한다")
	@Test
	public void support_minus() throws Exception{
		calculateUsingOperator(Value.valueOf(3), Value.valueOf(2), Operator.MINUS, Value.valueOf(1));
		calculateUsingOperator(Value.valueOf(3), Value.valueOf(2.5), Operator.MINUS,Value.valueOf(0.5));
		calculateUsingOperator(Value.valueOf(2), Value.valueOf(5), Operator.MINUS,Value.valueOf(-3));
	}

	@DisplayName("3. 곱하기(*)를 지원해야 한다")
	@Test
	public void support_multiply() throws Exception{
		calculateUsingOperator(Value.valueOf(1), Value.valueOf(1), Operator.MULTIPLY, Value.valueOf(1));
		calculateUsingOperator(Value.valueOf(3), Value.valueOf(-5.5), Operator.MULTIPLY, Value.valueOf(-16.5));
		calculateUsingOperator(Value.valueOf(1), Value.valueOf(0), Operator.MULTIPLY, Value.valueOf(0));
	}

	@DisplayName("4. 나누기(%)를 지원해야 한다")
	@Test
	public void support_divide() throws Exception{
		calculateUsingOperator(Value.valueOf(3), Value.valueOf(1), Operator.DIVIDE, Value.valueOf(3));
		calculateUsingOperator(Value.valueOf(3), Value.valueOf(2), Operator.DIVIDE, Value.valueOf(1.5));
		calculateUsingOperator(Value.valueOf(3), Value.valueOf(-2), Operator.DIVIDE, Value.valueOf(-1.5));

		assertThrows(IllegalArgumentException.class, () ->{
			Operator.DIVIDE.calculate(Value.valueOf(4), Value.valueOf(0));
			});

	}

	private void calculateUsingOperator(Value val1, Value val2, Operator op, Value expected) {
		Value result = op.calculate(val1, val2);
		assertEquals(expected, result);
	}

}
