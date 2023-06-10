package com.programmers.ui;

import java.util.Map;

public class OutputView {
	
	public void init() {
		System.out.println("1. 조회");
		System.out.println("2. 계산");
	}
	
	public void viewResult(Integer result) {
		System.out.println(result);
	}
	
	public void viewList(Map<String, Integer> list) {
		for (String expression : list.keySet()) {
			Integer result = list.get(expression);
			System.out.println(expression + " = " + result);
		}
	}
	
	public void eof() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void inputInOneAndTwo() {
		System.out.println("입력은 1과 2만 가능합니다.");
	}
	
	public void inputIsOnlyNumber() {
		System.out.println("입력은 오직 숫자만 가능합니다.");
	}
	
	public void divideByZeroException() {
		System.out.println("0으로 나눌 수 없습니다.");
	}
	
	public void invalidInputException() {
		System.out.println("잘못된 입력입니다.");
	}
	
}
