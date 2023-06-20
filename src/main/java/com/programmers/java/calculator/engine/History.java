package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Result;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class History {
    public static List<Result> records = new ArrayList<>();

    public History(List<Result> records) {
        this.records = records;
    }

    public List<Result> getRecords(){
        return records;
    }

    public void printRecords() {
        if (records.isEmpty()) {
            System.out.println("기록이 존재하지 않습니다.");
        }

        if(notEmpty(records)){
            System.out.println("---History---");
            records.forEach(result -> {
                System.out.println(result.toString());
            });
        }
    }

    private boolean notEmpty( List<Result> records){
        if(! records.isEmpty() ) return true;
        return false;
    }
}