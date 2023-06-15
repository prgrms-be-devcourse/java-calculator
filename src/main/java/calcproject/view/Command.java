package calcproject.view;

import java.util.Arrays;

public enum Command {

	EXIT(-1),
	INQUIRY(1),
	CALCULATE(2);
	private final int cmdIdx;

	Command(int cmdIdx) {
		this.cmdIdx = cmdIdx;
	}

	public static Command valueOf(int choiceNum) {
		Arrays.stream(values()).forEach(System.out::println);

		return Arrays.stream(values())
			.filter(value -> value.getCmdIdx() == choiceNum)
			.findAny()
			.orElse(CALCULATE.EXIT);
	}

	public int getCmdIdx() {
		return this.cmdIdx;
	}
}
