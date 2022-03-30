package org.programmers.calculator;

import org.programmers.calculator.configuration.Config;
import org.programmers.calculator.configuration.Operand;
import org.programmers.calculator.postfixCalculator.PostfixSolver;
import org.programmers.calculator.postfixParser.PostfixParser;
import org.programmers.calculator.repository.Repository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private PostfixParser parser;
    private PostfixSolver solver;
    private Repository repository;
    private final Scanner sc = new Scanner(System.in);

    public Menu(PostfixParser parser, PostfixSolver solver, Repository repository) {
        this.parser = parser;
        this.solver = solver;
        this.repository = repository;
    }

    public void run() throws InputMismatchException {
        System.out.println("==============================================");
        System.out.println("원하시는 작업 종류에 해당하는 번호를 입력해 주세요");
        System.out.println("1. 계산");
        System.out.println("2. 직전 저장 결과 조회");
        System.out.println("3. 저장 결과 검색");
        System.out.println("4. 전체 저장 결과 조회");
        System.out.println("5. 설정");
        System.out.println("==============================================");

        int input = sc.nextInt();
        sc.nextLine();

        switch (input) {
            case 1:
                calculation();
                break;
            case 2:
                inquirePreviousCalculation();
                break;
            case 3:
                searchRecordWithExpression();
                break;
            case 4:
                printAll();
                break;
            case 5:
                configure();
        }

    }

    private void calculation() {
        System.out.println("수식을 입력해 주세요.");
        String input = sc.nextLine();
        sc.nextLine();

        try {
            List<String> postFixExpression = parser.parse(input);
            String result = solver.solve(postFixExpression);
            System.out.println(result);
            repository.save(input, result);
        } catch (RuntimeException e) {
            String message = e.getMessage();
            System.out.println(message);
            repository.save(input, message);
        } finally {
            run();
        }
    }

    private void inquirePreviousCalculation() {
        String inquireResult = repository.findPrevious();
        if (inquireResult == null) {
            System.out.println("검색 결과가 없습니다.");
            return;
        } else {
            System.out.println(inquireResult);
        }
        run();
    }

    private void searchRecordWithExpression() {
        System.out.println("검색하시려는 연산을 정확히 입력해 주십시오.");
        String input = sc.nextLine();
        sc.nextLine();

        System.out.println(repository.findByKey(input));
        run();
    }

    private void printAll() {
        List<String> all = repository.printAll();
        for (String s : all) {
            System.out.println(s);
        }
        run();
    }

    private void configure() {
        System.out.println("피연산자를 선택해 주세요.");
        System.out.println("1. 유리수 2. 부울 값");
        int input = sc.nextInt();
        sc.nextLine();

        switch (input) {
            case 1: Config.set(Operand.RATIONAL_NUMBER);
            case 2: Config.set(Operand.BOOLEAN);
            default:
        };
        run();
    }
}
