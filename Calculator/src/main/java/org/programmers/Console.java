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
        System.out.println("\n1, 2번 중 선택하세요.\n");
    }

    @Override
    public void inputExError(int i) {
        if (i == 1) {
            System.out.println("\n수식을 잘못 입력하셨습니다.\n");
        } else {
            System.out.println("\n0 으로 나눌 수 없습니다.\n");
        }

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
        history.forEach(System.out::println);
        System.out.println();
    }
}
