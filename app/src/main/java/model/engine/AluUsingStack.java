package model.engine;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.primitives.Longs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import model.history.Record;
import model.input.Input;

public class AluUsingStack implements Alu {

	private Map<String, Integer> precedence = new HashMap<>();

	public AluUsingStack() {
		setUpPrecedence(precedence);
	}

	// 숫자가 높을수록 우선순위가 높다
	private void setUpPrecedence(Map<String, Integer> precedence) {
		precedence.put("+", 1);
		precedence.put("-", 1);
		precedence.put("/", 2);
		precedence.put("*", 2);
	}

	@Override
	public Record process(Input input) {
		return new Record(input.getOriginalExpression(),
			Long.toString(calculate(input.getParsedInput())));
	}

	private Optional<Long> parseToLong(String target) {
		return Optional.ofNullable(Longs.tryParse(target));
	}

	// throw DivideByZeroException ( IllegalArgumentException )
	private long calculate(String[] inputs) {
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
				values.add(parseToLong(inputs[i]).orElseThrow(
					() -> new IllegalArgumentException("정수가 아닌 입력값이 주어졌습니다")));
				continue;
			}
			// 연산자인 경우
			if (!operators.isEmpty() && isPrecededOrEqual(inputs[i], operators.getLast())) {
				// 연산자 스택의 최상위 연산자보다 현재 연산자의 우선순위가 더 낮은 경우
				op2 = values.pollLast();
				op1 = values.pollLast();
				result = operate(op1, op2, operators.pollLast());
				// 연산 결과를 values 에 push
				values.add(result);
			}
			operators.add(inputs[i]);
		}
		// 남아있는 연산자 및 값들에 대한 연산을 진행한다. 앞에서부터 순서대로 연산
		while (!operators.isEmpty()) {
			op2 = values.pollLast();
			op1 = values.pollLast();
			result = operate(op1, op2, operators.pollLast());
			values.add(result);
		}
		return values.getLast();
	}

	// 스택의 가장 위의 연산자보다 현재 연산자의 우선순위가 더 낮거나 같은 경우 -> 스택의 연산자로 계산해야함
	private boolean isPrecededOrEqual(String cur, String prior) {
		if (precedence.get(cur) <= precedence.get(prior)) {
			return true;
		}
		return false;
	}


	// 피연산자 1,2, 연산자
	private long operate(Long op1, Long op2, String op3) {
		checkArgument(op1 != null, "피연산자1(op1) 은 반드시 주어져야 합니다");
		checkArgument(op2 != null, "피연산자2(op2) 은 반드시 주어져야 합니다");
		Operator operator = null;

		switch (op3) {
			case "+":
				operator = Operator.PLUS;
				break;
			case "-":
				operator = Operator.MINUS;
				break;
			case "*":
				operator = Operator.MULTIPLY;
				break;
			case "/":
				operator = Operator.DIVIDE;
				break;
		}

		return operator.operate(op1, op2);
	}


}
