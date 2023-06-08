package org.example.io;

public class ConsoleOutput implements Output{
    @Override
    public void printAction(String action) {
        System.out.println(action);
    }

    @Override
    public void printCaculatedResult(int result) {
        System.out.println(result);
    }

    @Override
    public void printFindAll(String[] strings) {
        for (String str : strings){
            System.out.println(str);
        }
    }
}
