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
    public void printCalculatedResult(double result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printFindAll(String[] strings) {
        for (String str : strings){
            System.out.println(str);
        }
        System.out.println();
    }

    @Override
    public void printIoError() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.^^");
        System.out.println();
    }

    @Override
    public void printEquationError() {
        System.out.println("잘못된 수식이 입력 되었습니다.");
        System.out.println();
    }
}
