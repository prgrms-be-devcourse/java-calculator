package view.io;

import java.util.Scanner;

public class ConsoleIO implements IO {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void print(String output) {
        System.out.print(output);
    }
}