package View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int selectWorks() {
        Scanner sc = new Scanner(System.in);
        int workNum = sc.nextInt();
        return workNum;
    }

    public static String[] inputExpression() {
        Scanner sc = new Scanner(System.in);
        String[] expression = sc.nextLine().split(" ");
        return expression;
    }
}
