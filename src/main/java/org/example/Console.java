package org.example;

import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);

    public int  inputSelectMode(){
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        return  scanner.nextInt();
    }

    public String inputExpression(){
        return scanner.nextLine();
    }


    public void outputSelectResult(int mode){
        System.out.printf("선택 : %d%n", mode);
    }







}
