package src.cal.console;

import java.util.Scanner;

public class Console {
    private final Scanner gSc = new Scanner(System.in);

    public String next() {
        return gSc.next();
    }

    public void initialMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
        System.out.println();
    }

    public boolean validateSeletedNum(Integer seletedNum) {
        if (seletedNum == 1 || seletedNum == 2) {
            return true;
        }
        return false;
    }

    public void validateWarningMessage() {
        System.out.println("[INCORRECT_NUM] Select 1 or 2");
    }

    public boolean validateMenuUserInputedStr(String userInputedStr) {
        boolean isNumericSelectedStr = isNumeric(userInputedStr);
        boolean isCorrectMenuNum = false;
        int menuNum = 0;
        if (isNumericSelectedStr == false) {
            return false;
        }
        menuNum = Integer.parseInt(userInputedStr);
        isCorrectMenuNum = validateSeletedNum(menuNum);
        if (isCorrectMenuNum == false) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String string) {
        if(string == null || string.equals("")) {
            return false;
        }

        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
//            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}
