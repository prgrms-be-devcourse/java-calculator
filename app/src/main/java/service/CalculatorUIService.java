package service;

import model.Expression;
import repository.ResultRepository;

import java.util.Scanner;

public class CalculatorUIService {

    ResultRepository resultRepository = new ResultRepository();
    CalculateService calculateService = new CalculateService();

    private static final int RECORD = 1;
    private static final int CALCULATE = 2;


    public void showInterface() {
        Scanner scanner = new Scanner(System.in);
        Long expId = 0L;

        while (true) {
            expId += 1;

            showMenu();

            String selectMenu = scanner.nextLine();
            boolean isNumeric = selectMenu.chars().allMatch(Character::isDigit);
            if (!isNumeric) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            int menu = Integer.parseInt(selectMenu);

            System.out.println();

            if (menu != RECORD && menu != CALCULATE) {
                System.out.println("1과 2중에서만 골라주세요. :)");
                continue;
            }

            if (menu == RECORD) {
                calculateService.showRecord();
            } else {
                String userInput = scanner.nextLine();
                double result = calculateService.CalValue(userInput);
                System.out.println(result);

                Expression expression = new Expression(expId, userInput, result);
                resultRepository.save(expression);

            }
        }
    }

    private void showMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.print("선택 : ");
    }
}
