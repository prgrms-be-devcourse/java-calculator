package calculator.io;

import java.util.Scanner;

public class Input extends Adapter{
    Scanner sc = new Scanner(System.in);

    @Override
    public String input() {
        return sc.nextLine();
    }
}
