package calculator;

import java.util.Arrays;

public enum Menu {

	PRINT_FORMULAS("1"),
	CALCULATE("2"),
	EXIT("3"),
	ERROR("-1");

	private final String orderNumber;

	Menu(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public static Menu getOrder(String s) {
		return Arrays.stream(Menu.values())
			.filter(a -> a.orderNumber.equals(s))
			.findAny()
			.orElse(ERROR);
	}

}
