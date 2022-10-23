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

            if (state == 1) dataBase.showAll(); //  DB 조회
            else if (state == 2){
                formula.makeFormula(input.input(""));  // 실질적인 계산
                //
                // validate
                // 식에 문제가 없으면, 계산 진행
                //
                System.out.println(formula.getContent());
                formula.addData(dataBase, 0); // 일단 무조건 저장 : 만약 데이터가 올바르지 않으면 저장안할거임
                formula.clearContent();
            }
            else break;
        }
    }
}
