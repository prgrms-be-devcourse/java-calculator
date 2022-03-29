package org.programmers.calculator;

import org.programmers.calculator.configuration.ObjectContainer;
import org.programmers.calculator.postfixCalculator.Solver;
import org.programmers.calculator.postfixParser.PostfixParser;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void run() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();
        System.out.println("수식을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        while (true) {

            String input = sc.nextLine();
            List<String> postFixExpression = parser.parse(input);
            String result = solver.solve(postFixExpression);
            System.out.println(result);

            System.out.println("종료 하시겠습니까?(Y/N)");
            input = sc.nextLine();
            if (input.equals("Y")||input.equals("y")) {
                break;
            }
            else if (input.equals("N")||input.equals("n")) {
                System.out.println("수식을 입력해 주세요.");
            }
        }
    }
}
