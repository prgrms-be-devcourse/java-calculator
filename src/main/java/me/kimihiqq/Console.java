package me.kimihiqq;

import me.kimihiqq.io.Input;
import me.kimihiqq.io.Output;

import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String nextLine(){
        return scanner.nextLine();
    }
    @Override
    public String nextLine(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void println() {
        System.out.println();
    }
    @Override
    public void println(String prompt) {
        System.out.println(prompt);
    }
}
