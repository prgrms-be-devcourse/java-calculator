package org.programmers.calculator;

import org.programmers.calculator.configuration.ObjectContainer;
import org.programmers.calculator.postfixCalculator.Solver;
import org.programmers.calculator.postfixParser.PostfixParser;
import org.programmers.calculator.repository.Repository;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private PostfixParser parser;
    private Solver solver;
    private Repository repository;
    private String previousInput;
    private Scanner sc = new Scanner(System.in);

    public Menu(PostfixParser parser, Solver solver, Repository repository) {
        this.parser = parser;
        this.solver = solver;
        this.repository = repository;
    }

    public void run() {
        PostfixParser parser = ObjectContainer.getParser();
        Solver solver = ObjectContainer.getSolver();

        System.out.println("==============================================");
        System.out.println("원하시는 작업 종류에 해당하는 번호를 입력해 주세요");
        System.out.println("1. 계산");
        System.out.println("2. 직전 저장 결과 조회");
        System.out.println("3. 저장 결과 검색");
        System.out.println("4. 전체 저장 결과 조회");
        System.out.println("5. 설정");
        System.out.println("0. 종료");
        System.out.println("==============================================");

        int input = sc.nextInt();
        switch (input) {
            case 0: if (exit()) {return;} break;
            case 1: calculation(); break;
            case 2: inquirePreviousCalculation(); break;
            case 3: searchRecordWithExpression(); break;
            case 4: printAll(); break;
            case 5: configure();
        }

    }

    private boolean exit() {
        System.out.println("정말로 종료 하시겠습니까?(Y/N)");
        String input = sc.nextLine();
        if (input.equals("Y")||input.equals("y")) {
            return true;
        }
        return false;
    }

    private void calculation() {
        System.out.println("수식을 입력해 주세요.");
        String input = sc.nextLine();
        if (repository.findByKey(input)!=null) {
            System.out.println(repository.findByKey(input));
            return;
        }
        previousInput = input;
        List<String> postFixExpression = parser.parse(input);
        String result = solver.solve(postFixExpression);
        System.out.println(result);
        repository.save(previousInput, result);
    }

    private void inquirePreviousCalculation() {
        System.out.println(repository.findPrevious());
    }

    private void searchRecordWithExpression() {
        System.out.println("검색하시려는 연산을 다시 정확히 입력해 주십시오.");
        String input = sc.nextLine();
        System.out.println(repository.findByKey(input));
    }

    private void printAll() {
        List<String> all = repository.printAll();
        for (String s : all) {
            System.out.println(s);
        }
    }

    private void configure() {
        System.out.println("피연산자를 선택해 주세요.");
        System.out.println("1. 정수");
    }
}
