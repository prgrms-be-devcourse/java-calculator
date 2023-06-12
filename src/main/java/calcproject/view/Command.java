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

	public int getCmdIdx() {
		return this.cmdIdx;
	}

	public static Command valueOfCmd(int choiceNum) {
		return Arrays.stream(values())
			.filter(value -> value.equals(choiceNum))
			.findAny()
			.orElse(CALCULATE.EXIT);
	}
}
