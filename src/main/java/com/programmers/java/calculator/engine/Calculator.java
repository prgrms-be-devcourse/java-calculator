package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.Console;
import com.programmers.java.calculator.engine.exception.NumberIndexException;
import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;

import java.util.Scanner;

import static com.programmers.java.calculator.engine.Lookup.records;

public class Calculator implements Runnable{

    private final Scanner scanner = new Scanner(System.in);

    private Calculation calculation = new Calculation();
    private Input input;
    private Output output;
    private Lookup lookup = new Lookup();

    @Override
    public void run() {
        while(true){
            Console.printMenu();
            int num = scanner.nextInt();

            if(!validCheck(num)){
                throw new NumberIndexException("잘못된 입력입니다.");
            }
            else{
                if(num == 1) {  // 조회
                   lookup.printRecords();
                }
                else if(num == 2){ // 계산
                    scanner.nextLine();
                    String form = scanner.nextLine();
                    calculation.start(form);
                }
                else if(num == 9){
                    break;
                }
            }

        }
    }

    private boolean validCheck(int num) {
        if(num != 1 && num!=2 && num != 9) return false;
        else return true;
    }
}
