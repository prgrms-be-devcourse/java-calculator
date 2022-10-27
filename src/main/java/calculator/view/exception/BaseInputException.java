package calculator.view.exception;

public enum BaseInputException {

    BASE_INPUT_EXCEPTION("잘못된 입력으로 인하여 오류가 발생하였습니다.");

    private final String message;

    BaseInputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
