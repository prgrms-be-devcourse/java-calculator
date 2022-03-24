package org.programmers.service;

import java.util.Scanner;

public class MainService {
    CalculateService calculateService = new CalculateService();
    Validation validation = new Validation();

    public void runCalculator() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int select;

            System.out.println("1. 조회\n2. 계산\n");
            System.out.print("선택 : ");

            select = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if (select == 1) {
                calculateService.find();
            } else if (select == 2) {
                String inputEx = sc.nextLine();
                try {
                    double result = calculateService.calculateSave(inputEx);
                    System.out.println(result + "\n");
                } catch (Exception e) {
                    System.out.println("다시 입력하세요");
                }

            } else {
                System.out.println("그런 선택은 없어요");
            }
        }
    }
}
