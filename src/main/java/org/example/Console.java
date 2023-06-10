package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int inputSelectMode() throws IOException {
		System.out.println("1. 조회");
		System.out.println("2. 계산");
		int mode = Integer.parseInt(br.readLine());
		return mode;
	}

	public String inputExpression() throws IOException {
		System.out.println("값을 입력하세요!");
		String inputExpression = br.readLine();
		return inputExpression;
	}

	public void outputSelectResult(int mode) {
		System.out.printf("선택 : %d%n", mode);
	}

}
