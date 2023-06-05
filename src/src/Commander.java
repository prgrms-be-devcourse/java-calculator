import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Commander {

    // memorizer, calculator : Singleton.
    private static Memorizer memorizer = Memorizer.getInstance();

    private static Calculator calculator = Calculator.getInstance();


    public static void getMenu() {
        Scanner scanner = new Scanner(System.in);
        try {
            while(true) {
                printMenu();
                int menu = scanner.nextInt();

                if(menu == 3) {
                    System.out.println("Exit");
                    break;
                }
                // 조회
                else if(menu == 1) {
                    memorizer.show();
                }
                // 계산
                else if(menu == 2) {
                    // scanner buffer 비우기 위함.
                    scanner.nextLine();
                    String command = scanner.nextLine();
                    String[] commandArr = command.split(" ");
                    // commandArr check
                    if(!check(commandArr)) {
                        System.out.println("You've typed wrong menu!! Please re-type!!");
                        scanner.nextLine();
                        continue;
                    }
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

    public static boolean check(String[] command) {
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

    // ASCII값으로 판정.
    public static boolean isDigit(String s) {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((int)c - '0' < 0 || (int)c - '0' > 9)
                return false;
        }
        return true;
    }

    private static void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
    }

    public static void main(String[] args) {
        getMenu();
    }
}
