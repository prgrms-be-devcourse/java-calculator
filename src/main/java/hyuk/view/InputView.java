package hyuk.view;

import java.util.Scanner;

public class InputView {

    public String selectMenu(Scanner scanner) {
        String menu = scanner.next();

        if (menu.equals("1") || menu.equals("2")) {
            return menu;
        }
        throw new IllegalStateException("1 또는 2를 입력해주세요.");
    }

    public String inputExp(Scanner scanner) {
        String exp = scanner.nextLine();
        return exp;
    }
}
