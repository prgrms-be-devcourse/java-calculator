package com.programmers.javaCalculator.service;

import com.programmers.javaCalculator.component.Calculator;
import com.programmers.javaCalculator.component.Converter;
import com.programmers.javaCalculator.domain.Expression;
import com.programmers.javaCalculator.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class PostfixCalculatorService implements Runnable {

    private static final Scanner sc = new Scanner(System.in);

    private final Calculator calculator;
    private final Converter converter;
    private final Repository repository;

    @Override
    public void run() {
        while (true) {
            showMenu();

            String code = sc.nextLine();
            System.out.println();

            if (code.equals("1")) {
                showRecords(repository.findAll());
            }
            else if (code.equals("2")) {
                try {
                    String input = makeForm(sc.nextLine());
                    String postfix = getPostfix(input);
                    int result = getResult(postfix);

                    repository.save(new Expression(input, Integer.toString(result)));

                    System.out.println(result + "\n");
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage() + "\n");
                }
            }
            else if (code.equals("3")) {
                System.out.println("종료합니다.");
                break;
            }
            else {
                System.out.println("적절한 코드를 입력하세요.\n");
            }
        }
    }

    public String makeForm(String input) {
        return input.trim().replaceAll(" +", " ");
    }

    /* Output 클래스를 따로 구현하지 않고 간단히 showMenu()와 showRecords()로 구현 */
    public void showMenu() {
        System.out.print("1. 조회\n2. 계산\n3. 종료\n\n선택 : ");
    }

    public void showRecords(List<Expression> list) {
        list.stream().forEach(System.out::println);
        System.out.println();
    }

    public String getPostfix(String infix) {
        return converter.put(infix).convert();
    }

    public int getResult(String postfix) {
        return calculator.calculate(postfix);
    }

}
