package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.example.exception.CaculatorApplicationException;

public class Console {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int inputSelectMode() throws IOException, CaculatorApplicationException {
		System.out.println("1. 조회");
		System.out.println("2. 계산");
		String inputSelectMode = br.readLine();
		if (!(inputSelectMode.equals("1") || inputSelectMode.equals("2"))) {
			throw new CaculatorApplicationException("Invalid input");
		}
		int mode = Integer.parseInt(inputSelectMode);
		return mode;
	}

	public String inputExpression() throws IOException {
		System.out.println("연산식을 입력해라");
		String inputExpression = br.readLine();
		return inputExpression;
	}

	public void outputSelectResult(int mode) {
		System.out.printf("선택 : %d%n", mode);
	}

}
