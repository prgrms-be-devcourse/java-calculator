package calculator.view.exception;

public enum MenuInputException {

    MENU_INPUT_NULL_EXCEPTION("메뉴 선택에서 잘못된 입력으로 인하여 오류가 발생하였습니다.");

    public final String message;

    MenuInputException(String message) {
        this.message = message;
    }
}
