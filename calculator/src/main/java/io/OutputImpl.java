package io;

public class OutputImpl implements Output {
    public final String PRINT = "메뉴를 선택하세요\n1. 조회\n2. 계산\n3. 종료\n선택:";
    public final String CAL = "계산 식을 입력하세요:";
    @Override
    public void printResult(String output) {
        System.out.println(output);
    }

    @Override
    public void printOption() {
        System.out.println(PRINT);
    }

    @Override
    public void printGuide() {
        System.out.println(CAL);
    }
}
