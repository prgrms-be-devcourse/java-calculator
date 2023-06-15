package com.programmers.ui;

import com.programmers.exception.AbnormalTerminationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
	
	private final BufferedReader br;
	
	public InputView() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String select() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throwAbnormalTerminationException();
		}
		return null;
	}

	public String formula() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throwAbnormalTerminationException();
		}
		return null;
	}
	
	public void close() {
		try {
			br.close();
		} catch (IOException e) {
			throwAbnormalTerminationException();
		}
	}
	
	private AbnormalTerminationException throwAbnormalTerminationException() {
		return new AbnormalTerminationException("입력에 예외가 발생하여 비정상적으로 종료되었습니다.");
	}
	
}
