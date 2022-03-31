package service;

import model.Expression;
import repository.ResultRepository;

import java.util.Scanner;

public class CalculatorUIService {

    ResultRepository resultRepository = new ResultRepository();
    CalculateService calculateService = new CalculateService();


    public void showInterface() {
        Scanner scanner = new Scanner(System.in);
        Long expId = 0L;

        while (true) {
            expId += 1;

            System.out.println("1. 조회");
            System.out.println("2. 계산");
            System.out.print("선택 : ");

            int number = Integer.parseInt(scanner.nextLine());
            System.out.println();
            if (number != 1 && number != 2) {
                // 1과 2 둘 중 하나를 선택해 달라는 메세지 요청
                System.out.println("1과 2중에서만 골라주세요. :)");
                continue;
            }

            if (number == 1) {
                resultRepository.showRecord();
            } else if (number == 2) {
                String userInput = scanner.nextLine();
                double result = calculateService.CalValue(userInput);
                System.out.println(result);

                Expression expression = new Expression(expId, userInput, result);
                resultRepository.save(expression);

            }
        }
    }
}
