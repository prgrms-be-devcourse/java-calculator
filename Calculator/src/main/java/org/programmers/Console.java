package org.programmers;

import org.programmers.entity.ResultModel;
import org.programmers.service.IO.Input;
import org.programmers.service.IO.Output;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private Scanner sc;
    @Override
    public String selectFuction(String prompt) {
        System.out.print(prompt);

        return new Scanner(System.in).nextLine();
    }

    @Override
    public String inputExpression() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void inputNumError() {
        System.out.println("1, 2번 중 선택하세요.");
    }

    @Override
    public void inputExError() {
        System.out.println("수식을 잘못 입력하셨습니다.");
    }

    @Override
    public void printMenu() {
        System.out.println("1.조회\n2.계산\n");
    }

    @Override
    public void printResult(double result) {
        System.out.println(result + "\n");
    }

    @Override
    public void historyInquiry(List<ResultModel> history) {
        history.stream()
                .forEach(System.out::println);
    }
}
