package org.example.io;

public class ConsoleOutput implements Output{
    @Override
    public void printAction() {
        System.out.println("1.조회");
        System.out.println("2.계산");
        System.out.println("3.종료");
        System.out.print("선택: ");
    }

    @Override
    public void printCaculatedResult(double result) {
        System.out.println(result);
    }

    @Override
    public void printFindAll(String[] strings) {
        for (String str : strings){
            System.out.println(str);
        }
    }
}
