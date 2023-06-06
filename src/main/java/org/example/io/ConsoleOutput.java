package org.example.io;

public class ConsoleOutput implements Output{
    @Override
    public void printAction(String action) {
        System.out.println(action);
    }

    @Override
    public void printCaculatedResult(long result) {
        System.out.println(result);
    }
}
