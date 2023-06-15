package util;

public class CalculatorUtils {
    public static int parseCharToInteger(char input) {
        int parsedValue = Character.digit(input, 10);

        if (parsedValue == -1) {
            throw new NumberFormatException("[ERROR] 수로 변환할 수 없는 문자가 입력됐습니다.");
        }

        return parsedValue;
    }

    public static int parseStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 수로 변환할 수 없는 문자열이 입력됐습니다.");
        }
    }

    public static boolean isDigitCharacter(char input) {
        return Character.isDigit(input);
    }
}
