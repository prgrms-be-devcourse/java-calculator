package com.programmers.java.engine.utils;

public class Function {
	public static boolean isStrDigit(String str) {

		for (int i = 0; i < str.length(); i++) {
			if (str.length() == 1 && str.charAt(0) == '-') {
				return false;
			}

			if (i > 0 && !Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	public static boolean isOperator(String str) {
		if (str.length() > 1) {
			return false;
		}

		return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
	}
}
