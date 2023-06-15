package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Result;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class Lookup {
    static ArrayList<Result> records = new ArrayList<Result>();

    // 연산식, 연산 결과 받아서 저장
    void record(Result result){
        records.add(result);
    }

    void printRecords(){
        if(records.isEmpty()){
            System.out.println("기록이 존재하지 않습니다.");
        }
        else {
            records.forEach(result -> {
                System.out.println(result.toString());
            });
        }
    }

}
