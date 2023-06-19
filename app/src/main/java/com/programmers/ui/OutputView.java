package com.programmers.ui;

import java.util.List;

public class OutputView {
	
	public void init() {
		System.out.println("1. 조회");
		System.out.println("2. 계산");
		System.out.println("3. 종료");
		System.out.print("\n선택 : ");
	}
	
	public void viewResult(Integer result) {
		System.out.println(result + "\n");
	}
	
	public void viewRecord(List<String> record) {
		System.out.print("\n");
		if (record != null) {
			record.stream().forEach(System.out::println);
			System.out.print("\n");
		}
	}
	
	public void exit() {
		System.out.println("\n프로그램을 종료합니다.");
	}
	
	public void printExceptionMessage(String message) {
		System.out.println(message);
	}
	
}
