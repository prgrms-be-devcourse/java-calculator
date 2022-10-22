package com.programmers.engine;

import com.programmers.engine.io.*;
import com.programmers.engine.model.*;
import com.programmers.engine.stack.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable{

    private Input input;
    private Output output;

    private DataBase dataBase;
    private Formula formula;


    @Override
    public void run() {
        while(true){
            int state = Integer.parseInt(input.input("1. 조회\n2. 계산\n"));

            if (state == 1) {
                dataBase.showAll();
                System.out.println("DB 조회 선택");
            } //  DB 조회
            else if (state == 2){
                formula.setContent(input.input(""));  // 실질적인 계산
                System.out.println("계산 선택");
                System.out.println(formula.getContent());
            }
            else break;
        }
    }
}
