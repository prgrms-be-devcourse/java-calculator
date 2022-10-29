package com.programmers.java.io;

import java.util.Arrays;

public enum Menu {
	LOOKUP("1"), CALCULATION("2"), EXIT("3");

	private String value;

	Menu(String value) {
		this.value = value;
	}

	public static Menu selectMenu(String choice) {
		return Arrays.stream(Menu.values())
			.filter(num -> num.value.equals(choice))
			.findFirst()
			.orElseThrow();
	}
}
