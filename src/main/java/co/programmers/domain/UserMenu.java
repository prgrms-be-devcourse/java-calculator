package co.programmers.domain;

import java.util.Arrays;

public enum UserMenu {
	INQUIRY(1), CALCULATE(2), TERMINATE(3), ERROR(-9999);

	private final Integer menu;

	private UserMenu(Integer value) {
		this.menu = value;
	}

	public static UserMenu get(Integer input) {
		return Arrays.stream(values())
				.filter(menuNum -> menuNum.menu.equals(input))
				.findFirst()
				.orElse(ERROR);
	}
}
