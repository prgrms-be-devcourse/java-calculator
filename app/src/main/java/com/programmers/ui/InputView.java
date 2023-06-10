package com.programmers.ui;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView {
	
	public String select(BufferedReader br) throws IOException {
		return br.readLine();
	}

	public String expression(BufferedReader br) throws IOException {
		return br.readLine();
	}
	
}
