package service;

import java.util.Scanner;

public class CalculatorUIService {

    public void runCalculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 조회");
            System.out.println("2. 계산");
            System.out.println();
            System.out.print("선택 : ");

            int number = scanner.nextInt();
            if (number != 1 && number != 2) {
                // 1과 2 둘 중 하나를 선택해 달라는 메세지 요청
                System.out.println("1과 2중에서만 골라주세요. :)");
                continue;
            }

            if (number == 1) {
                /**
                 *  조회로직
                 *  "값 연산자 값 =" 결과의 형태로 담을 공간 필요
                 *
                 */
            } else {
                String exp = scanner.nextLine();

            }
        }
    }
}
