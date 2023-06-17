package com.programmers.calculator;

import com.programmers.util.Operator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;

public class PostfixCalculator {
	
	private static final Pattern NUMBER = Pattern.compile("\\d+");
	
	public Integer calculatePostfix(List<String> postfix) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		postfix.stream()
				.forEach(s -> { calculatePostfixWithDeque(s, deque); });
		
		return deque.pollLast();
	}
	
	private void calculatePostfixWithDeque(String s, Deque<Integer> deque) {
		if (NUMBER.matcher(s).matches()) {
			deque.addLast(Integer.parseInt(s));
			return;
		}
		// 연산자 일 경우
		Integer op1 = deque.pollLast();
		Integer op2 = deque.pollLast();
		
		Operator calc = Operator.of(s);
		Integer result = calc.calculateOperation(op2, op1);
		
		deque.addLast(result);
	}
	
}
