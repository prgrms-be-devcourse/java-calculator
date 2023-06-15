package com.programmers.calculator;

import com.programmers.util.Operator;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class Calculator {
	
	private final Pattern NUMBER = Pattern.compile("\\d+");
	
	public List<String> changeInfixToPostfix(List<String> infix) {
		List<String> postfix = new ArrayList<>();
		Deque<String> deque = new ArrayDeque<>();
		
		infix.stream()
			.forEach(s -> {
				if (NUMBER.matcher(s).matches()) { // 숫자일 경우
					postfix.add(s);
				} else { // 숫자 아닐 경우
					Operator operator = Operator.of(s);
					int priority = operator.getPriority();
					// 덱이 비었거나
					while (!deque.isEmpty()) {
						Operator topOperator = Operator.of(deque.peekLast());
						int topPriority = topOperator.getPriority();
						
						// top의 우선 순위가 높거나 같을 경우
						if (topPriority >= priority) postfix.add(deque.pollLast());
							// top의 우선 순위가 낮을 경우
						else break;
					}
					deque.addLast(s); // 연산자 넣음
				}
			});
		
		// 스택에 남아있는 연산자 모두 집어 넣음
		while (!deque.isEmpty()) postfix.add(deque.pollLast());
		
		return postfix;
	}
	
	public Integer calculatePostfix(List<String> postfix) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		postfix.stream()
				.forEach(s -> {
					// 숫자일 경우 덱에 넣음
					if (NUMBER.matcher(s).matches()) deque.addLast(Integer.parseInt(s));
					else { // 연산자 일 경우
						Integer op1 = deque.pollLast();
						Integer op2 = deque.pollLast();
						
						Operator calc = Operator.of(s);
						Integer result = calc.calculateOperation(op2, op1);
						
						deque.addLast(result);
					}
				});
		
		return deque.pollLast();
	}
	
}
