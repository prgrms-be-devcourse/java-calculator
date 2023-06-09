package calcproject.view;

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
}
