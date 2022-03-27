import io.Input;
import io.Output;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console implements Input, Output {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void menu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
    }
    @Override
    public int selectMenu() {
        System.out.print("선택 : ");
        return Integer.parseInt(scanner.nextLine());
    }
    @Override
    public void inputError() {
        System.out.println("입력이 올바르지 않습니다");
    }


    @Override
    public void history(List<String> history) {
        for(var operation : history){
            System.out.println(operation);
        }
    }

    @Override
    public void result(Number number) {
        if(number instanceof Integer)
            System.out.println(number.intValue());
        else
            System.out.println(number.doubleValue());
    }

    @Override
    public String operation() {
        String expression = scanner.nextLine();
        expression.replace(" ","");
        if(isOperationValid(expression))
            return expression;
        else
            return operation();
    }

    static boolean isOperationValid(String operation){
        String pattern = "[-+]?([0-9][-+*/])*[0-9]$";
        return Pattern.matches(pattern, operation);
    }

    @Override
    public void exit() {
        System.out.println("종료합니다.");
    }
}
