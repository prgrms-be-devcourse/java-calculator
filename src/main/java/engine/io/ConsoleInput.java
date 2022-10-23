package engine.io;

import java.util.Scanner;

public class ConsoleInput implements Input{
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String showOption(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    @Override
    public String getCalculateSentence(String msg) {
        return sc.nextLine();
    }
}
