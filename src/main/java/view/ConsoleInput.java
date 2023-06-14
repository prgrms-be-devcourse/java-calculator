package main.java.view;

import main.java.domain.Menu;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static main.java.domain.Menu.getMenu;
import static main.java.service.Operator.isValidOperator;
import static main.java.view.ConsoleOutput.printError;


public class ConsoleInput implements Input{

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMINATOR = " ";
    public static final int SHOWMENU = 1;
    public static final int CALCULATEMENU = 2;
    public static final int EXITMENU = 0;

    public Menu getMenuInput() {
        String line = scanner.nextLine();
        String[] lineArr = line.split(DELIMINATOR);
        String menuCandidate = lineArr[0];
        if (lineArr.length >= 2 || !isValidNumber(menuCandidate)
                || Integer.parseInt(menuCandidate) >= Menu.menuCount
                || Integer.parseInt(menuCandidate) < 0) {
            throw new IllegalArgumentException(printError("MENU"));
        }
        return getMenu(Integer.parseInt(menuCandidate));
    }

    public String[] getLineAndParse() {
        String[] commandArr = scanner.nextLine().split(DELIMINATOR);
        if(!isValidCommand(commandArr))
            throw new IllegalArgumentException(printError("COMMAND"));
        return commandArr;
    }

    public static void scannerClose() {
        scanner.close();
    }

    // 각각 숫자 , 연산자에 대해 맞는 command인지 검사.
    public boolean isValidCommand(String[] commandArr) {
        String commandEntity;
        for(int i = 0; i < commandArr.length; i++) {
            commandEntity = commandArr[i];
            if(i % 2 == 0) {
                if(!isValidNumber(commandEntity))
                    return false;
            }
            else {
                if(!isValidOperator(commandEntity))
                    return false;
            }
        }
        return true;
    }

    private static boolean isValidNumber(String commandEntity) {
        for(int i = 0; i < commandEntity.length(); i++) {
            if(!Character.isDigit(commandEntity.charAt(i)))
                return false;
        }

        return true;
    }

}
