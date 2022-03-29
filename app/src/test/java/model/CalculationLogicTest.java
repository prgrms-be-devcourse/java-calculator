package model;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.primitives.Longs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculationLogicTest {

	@Test
	public void 문자열_배열을_받아_계산하기() {
		String[] inputs = new String[]{"1", "+", "3", "*", "2"};
		long expected = 7L;
		Assertions.assertEquals(expected, calculateFirstlyMulNDivide(inputs));
	}
	@Test
	public void 롱타입_계산_확인하기(){
		String[] inputs = new String[]{"1000000", "*", "10000000"};
		long expected = 10000000000000L;
		Assertions.assertEquals(expected,calculateFirstlyMulNDivide(inputs));
	}

	@Test
	public void 나눗셈이포함된_연산_계산하기() {
		String[] inputs = new String[]{"1", "+", "4", "/", "2"};
		long expected = 3L;
		Assertions.assertEquals(expected, calculateFirstlyMulNDivide(inputs));
	}

	@Test
	public void 예외상황_0으로_나눈_경우() {
		String[] inputs = new String[]{"1", "+", "3", "/", "0"};
		Assertions.assertThrows(ArithmeticException.class, () -> calculateFirstlyMulNDivide(inputs));
	}

	private void setUpPrecedence(Map<String, Integer> precedence) {
		precedence.put("+", 1);
		precedence.put("-", 1);
		precedence.put("/", 2);
		precedence.put("*", 2);
	}

	private Optional<Long> parseToLong(String target) {
		return Optional.ofNullable(Longs.tryParse(target));
	}

	// 로직을 여기서 테스트 해 볼 거임
	// throws IllegalArgumentException
	private long calculateFirstlyMulNDivide(String[] inputs) {
		Map<String, Integer> precedence = new HashMap<>();
		setUpPrecedence(precedence);

		LinkedList<Long> values = new LinkedList<>();
		LinkedList<String> operators = new LinkedList<>();

		Long op1 = null;
		Long op2 = null;
		long result = 0;

		// inputs 을 순회하면서 operators 가 비어있지 않은 경우 -> operators 의 top 에 있는 연산자와 현재 연산자의 우선순위를 비교한다
		// 현재 연산자의 우선순위가 더 낮거나 같을 경우, 스택에서 값을 2개 꺼내 연산한다.

		for (int i = 0; i < inputs.length; i++) {
			// precedence 에 없는 값 -> 숫자
			if (!precedence.containsKey(inputs[i])) {
				values.add(
					parseToLong(inputs[i]).orElseThrow(
						() -> new IllegalArgumentException("정수가 아닌 입력값이 주어졌습니다")
					)
				);
				continue;
			}
			// 연산자인 경우
			if (!operators.isEmpty() && isPrecededOrEqual(inputs[i], operators.getLast(), precedence)) {
				// 연산자 스택의 최상위 연산자보다 현재 연산자의 우선순위가 더 낮거나 같을 경우 경우
				op2 = values.pollLast();
				op1 = values.pollLast();
				result = calculate(op1, op2, operators.getLast());
				// 연산 결과를 values 에 push
				values.add(result);
			}
			operators.add(inputs[i]);
		}
		// 남아있는 연산자 및 값들에 대한 연산을 진행한다
		while (!operators.isEmpty()){
			op2 = values.pollLast();
			op1 = values.pollLast();
			result = calculate(op1, op2, operators.pollLast());
			values.add(result);
		}
		return values.getLast();
	}

	// 현재 연산자의 우선순위가 더 낮거나 같은 경우 리턴 트루 -> 그러면 스택의 가장 위에 있는 연산자로 연산을 수행한다
	private boolean isPrecededOrEqual(String cur, String prior, Map<String, Integer> precedence) {
		if (precedence.get(cur) < precedence.get(prior)) {
			return true;
		}
		return false;
	}


	// 피연산자 1,2, 연산자
	private long calculate(Long op1, Long op2, String op3) {
		checkArgument(op1 != null,"op1 must be provided");
		checkArgument(op2 != null, "op2 must be provided");
		long res = 0;
		switch (op3){
			case "+":
				res =  op1 + op2;
				break;
			case "-":
				res = op1 - op2;
				break;
			case "*":
				res= op1 * op2;
				break;
			case "/":
				res =  op1 / op2;
				break;
		}
		return res;
	}


}
