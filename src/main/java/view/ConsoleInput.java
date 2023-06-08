package main.java.view;

import main.java.domain.Menu;
import main.java.exception.OutOfMenuException;
import main.java.exception.WrongCommandException;

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

    @Override
    public Menu getMenuInput() throws OutOfMenuException {
        String line = scanner.nextLine();
        String[] lineArr = line.split(DELIMINATOR);
        String menuCandidate = lineArr[0];
        if (lineArr.length >= 2 || !checkIsNumber(menuCandidate)
                || Character.getNumericValue(menuCandidate.charAt(0)) >= Menu.menuCount
                || Character.getNumericValue(menuCandidate.charAt(0)) < 0) {
            throw new OutOfMenuException(printError("MENU"));
        }
        return getMenu(Integer.parseInt(menuCandidate));
    }

    @Override
    public String[] getLineAndParse() throws WrongCommandException {
        String[] commandArr = scanner.nextLine().split(DELIMINATOR);
        if(!isValidCommand(commandArr))
            throw new WrongCommandException(printError("COMMAND"));
        return commandArr;
    }
    public static void scannerClose() {
        scanner.close();
    }
    public static void flushBuffer() {
        scanner.nextLine();
    }


    // 각각 숫자 , 연산자에 대해 맞는 command인지 검사.
    public boolean isValidCommand(String[] commandArr) {
        String commandEntity;
        for(int i = 0; i < commandArr.length; i++) {
            commandEntity = commandArr[i];
            if(i % 2 == 0) {
                if(!checkIsNumber(commandEntity))
                    return false;
            }
            else {
                if(!isValidOperator(commandEntity))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkIsNumber(String commandEntity) {
        for(int i = 0; i < commandEntity.length(); i++) {
            if(!Character.isDigit(commandEntity.charAt(i)))
                return false;
        }

        return true;
    }

}
