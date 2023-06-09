package calcproject.view;

public enum Messages {
	INPUT_GUIDE_MESSAGE("1.조회 \n2.계산\n"),
	INPUT_CHOICE_MESSAGE("선택 : "),
	EXIT_MESSAGE("종료 합니다.");

	private final String message;

	Messages(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
