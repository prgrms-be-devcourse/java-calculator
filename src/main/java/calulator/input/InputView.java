package calulator.input;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputMenu() {
        System.out.println("1. 조회\n2. 계산\n");
        System.out.printf("선택 : ");
        return Integer.parseInt(inputLineWithoutBlank());
    }

    private String inputLineWithoutBlank() {
        return scanner.nextLine().replaceAll("//s","");
    }

}
