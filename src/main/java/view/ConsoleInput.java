package main.java.view;

import main.java.domain.Menu;

import java.util.Scanner;

import static main.java.domain.Menu.getMenu;
import static main.java.service.Operator.isValidOperator;


public class ConsoleInput implements Input{

    private static final Scanner scanner = new Scanner(System.in);
    public static final String ERROR_MESSAGE = "Unavailable Input !! Please re-type!!";
    private static final String DELIMINATOR = " ";
    public static final int SHOWMENU = 1;
    public static final int CALCULATEMENU = 2;
    public static final int EXITMENU = 0;

    @Override
    public Menu getMenuInput() {
        return getMenu(scanner.nextInt());
    }

    @Override
    public String[] getLineAndParse() {
        return scanner.nextLine().split(DELIMINATOR);
    }
    public static void scannerClose() {
        scanner.close();
    }
    public void flushBuffer() {
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
