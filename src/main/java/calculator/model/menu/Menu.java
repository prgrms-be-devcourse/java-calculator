package calculator.model.menu;

import java.util.Arrays;

public enum Menu {
    EXIT('0', "종료"),
    CALCULATION_HISTORY('1', "조회"),
    CALCULATE('2', "계산");

    private final Character command;
    private final String explanation;

    private static final Integer MENU_INPUT_LENGTH = 1;
    private static final Integer FIRST_INDEX = 0;

    Menu(Character command, String explanation) {
        this.command = command;
        this.explanation = explanation;
    }

    public Character getCommand(){
        return command;
    }

    public static boolean isValidMenuInput(String input){
        if (input.length() != MENU_INPUT_LENGTH) return false;
        Character firstChar = input.charAt(FIRST_INDEX);
        return Arrays.stream(Menu.values()).filter(m -> m.getCommand()
                .equals(firstChar)).count() == 1;
    }

    @Override
    public String toString() {
        return command + ". " + explanation;
    }
}
