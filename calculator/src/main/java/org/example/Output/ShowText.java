package org.example.Output;

public class ShowText implements Show{
    @Override
    public void showMenu() {
        System.out.println("1. 조회\n2. 계산\n");
        System.out.print("선택 : ");
    }
}
