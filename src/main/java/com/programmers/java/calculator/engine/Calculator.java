package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.Console;
import com.programmers.java.calculator.engine.exception.NumberIndexException;
import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;

import java.util.Scanner;

public class Calculator implements Runnable{

    private final Scanner scanner = new Scanner(System.in);
    private Input input;
    private Output output;

    @Override
    public void run() {
        while(true){
            Console.printMenu();
            int num = input.parseToInt(scanner.nextLine());

            if(!validCheck(num)){
                throw new NumberIndexException("잘못된 입력입니다.");
            }
            else{
                if(num == 1) {  // 조회
                    scanner.nextLine();
                }
                else { // 계산

                }
            }

        }
    }

    private boolean validCheck(int num) {
        if(num!=1 || num!=2) return false;
        else return true;
    }
}
