package com.programmers.calculator;

import com.programmers.util.Operator;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class PostfixConversion {
	
	private static final Pattern NUMBER = Pattern.compile("\\d+");
	
	public List<String> changeInfixToPostfix(List<String> infix) {
		List<String> postfix = new ArrayList<>();
		Deque<String> deque = new ArrayDeque<>();
		
		infix.stream()
			 .forEach(s -> { makePostfixWithDeque(s, postfix, deque); });
		
		// 스택에 남아있는 연산자 모두 집어 넣음
		while (!deque.isEmpty()) postfix.add(deque.pollLast());
		
		return postfix;
	}
	
	private void makePostfixWithDeque(String s, List<String> postfix, Deque<String> deque) {
		if (NUMBER.matcher(s).matches()) { // 숫자일 경우
			postfix.add(s);
			return;
		}
		// 숫자 아닐 경우
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
	
}
