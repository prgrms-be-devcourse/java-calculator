import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input console

        ArrayList<String> calResultList = new ArrayList<>();

        while(true) {
            System.out.println("1: 조회");
            System.out.println("2: 계산");

            int chooseNumber = 1;
            Scanner in = new Scanner(System.in);
            System.out.printf("선택: ");
            chooseNumber = in.nextInt();

            if (chooseNumber == 1) {
//                System.out.println("cal result list:" + calResultList);
                for (String calResult : calResultList) {
                    System.out.println(calResult);
                }
            } else {
                double calResult = 0;
                Scanner in2 = new Scanner(System.in);
                String expression = in2.nextLine();
                Calculator calc = new Calculator();
                calResult = calc.compute(expression);
                System.out.println(calResult);
                calResultList.add(expression + "=" + calResult);
            }

            System.out.println();
        }
    }
}
