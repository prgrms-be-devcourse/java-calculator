package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);
    private static final String ERROR_MESSAGE = "Unavailable Input !! Please re-type!!";

    public static final int SHOWMENU = 1;
    public static final int CALCULATEMENU = 2;
    public static final int EXITMENU = 3;

    // TODO : 메서드명 수정
    public void getMenuInput() {
        try {
            while(true) {
                // TODO : 메뉴가 늘어나면 if 계속추가해야된다.
                int menu = scanner.nextInt();

                if(menu == EXITMENU) {
                    System.out.println("Exit");
                    break;
                }
                // 조회
                else if(menu == SHOWMENU) {
                    OutputView.showHistory();
                }
                // 계산
                else if(menu == CALCULATEMENU) {
                    // scanner buffer 비우기 위함.
                    // TODO : 입력받는건 또 다른 메소드로 빼자.
                    // TODO : 리턴값만 받아서 save.
                    String[] commandArr = getCommandInput();
                    if(commandArr.equals(null)) {
                        System.out.println(ERROR_MESSAGE);
                        continue;
                    }
                    // commandArr check
                    int result = calculator.calculate(commandArr);
                    System.out.println("result : " + result);
                    String resultStr = command + " = " + result;
                    memorizer.save(resultStr);
                }

                else {
                    System.out.println("You've typed wrong menu!! Please re-type!!");
                    scanner.nextLine();
                }
            }
        }
        // Problem :
        // 선택 : 2 + 3 / 2같은, nextint()를 이미 받아버리면
        // 정상작동한다.
        catch (InputMismatchException e) {
            System.out.println("You've typed wrong menu!! Please re-type!!");
            scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("You've typed wrong menu!! Please re-type!!");
            scanner.nextLine();
        }
        scanner.close();
    }

    private String[] getCommandInput() {
        String command = scanner.nextLine();

        String[] commandArr = command.split(" ");

        if(isValidCommand(commandArr))
            return commandArr;

        return null;
    }
    private boolean isValidCommand(String[] commandArr) {
        String commandEntity;
        for(int i = 0; i < commandArr.length; i++) {
            commandEntity = commandArr[i];
            if(i % 2 == 0) {
                if()
                    return false;
            }
            else {
                if()
            }
        }
    }
    private static boolean check(String[] command) {
        String s;
        for(int i = 0; i < command.length; i++) {
            s = command[i];
            if(i % 2 == 0) {
                if(!isDigit(s)) {
                    return false;
                }
            }
            else {
                if( (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ) == false )
                    return false;
            }
        }

        return true;
    }


}
