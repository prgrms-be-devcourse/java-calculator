package calcproject;

import calcproject.repository.MemoryCalcModelRepository;
import calcproject.service.CalcManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalcManager calcManager = new CalcManager(new MemoryCalcModelRepository());

        while(true) {
            System.out.println("1. 조회");
            System.out.println("2. 계산 \n");

            System.out.println("선택 :");

            Scanner sc = new Scanner(System.in);
            Integer choice_num = sc.nextInt();
            sc.nextLine();

            switch (choice_num) {
                case 1:
                    calcManager.printHistory();
                    break;
                case 2:
                    String expression = sc.nextLine();
                    double r = calcManager.calculateExpressionAndSave(expression);
                    System.out.println(r);
                    System.out.println();
                    break;
                default:
                    System.out.println("잘 못된 입력입니다.");
                    break;
            }
        }
    }
}
