package com.programmers.calculator;

import java.util.*;

public class Calculator {
	
	public List<String> changeInfixToPostfix(List<String> infix) {
		List<String> postfix = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		
		for (String s : infix) {
			if (s.matches("\\d+")) { // 숫자일 경우
				postfix.add(s);
			} else { // 숫자 아닐 경우
				int priority = getPriority(s);
				// 스택이 비었거나
				while (!stack.isEmpty()) {
					String topOperator = stack.peek();
					int topPriority = getPriority(topOperator);
					
					// top의 우선 순위가 높거나 같을 경우
					if (topPriority >= priority) postfix.add(stack.pop());
					// top의 우선 순위가 낮을 경우
					else break;
				}
				stack.push(s); // 연산자 넣음
			}
		}
		
		// 스택에 남아있는 연산자 모두 집어 넣음
		while (!stack.isEmpty()) postfix.add(stack.pop());
		
		return postfix;
	}
	
	public Integer calcPostfix(List<String> postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for (String s : postfix) {
			// 숫자일 경우 스택에 넣음
			if (s.matches("\\d+")) stack.push(Integer.parseInt(s));
			else { // 연산자 일 경우
				Integer op1 = stack.pop();
				Integer op2 = stack.pop();
				
				Operator calc = Operator.of(s);
				Integer result = calc.getFunc().apply(op2, op1);
				
				stack.push(result);
				
				System.out.println(stack.size());
			}
		}
		
		return stack.pop();
	}
	
	public Integer getPriority(String operator) {
		// * 와 / 는 우선순위 높음
		if (operator.equals("*") || operator.equals("/")) return 1;
		// 그 외 낮음
		return -1;
	}
	
}
