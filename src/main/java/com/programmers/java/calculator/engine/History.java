package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.io.Console;
import com.programmers.java.calculator.engine.model.Result;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class History {
    public static List<Result> records = new ArrayList<>();  //TODO: 일급컬렉션으로 변경
    private Console console = new Console();

    public History(List<Result> records) {
        this.records = records;
    }

    public List<Result> getRecords(){
        return records;
    }

    public void printRecords() {
        if (records.isEmpty()) {
            console.printError("기록이 존재하지 않습니다.");
        }

        if(notEmpty(records)){
            console.printMsg("---History---");
            records.forEach(result -> {
                console.printMsg(result.toString());
            });
        }
    }

    private boolean notEmpty( List<Result> records){
        if(! records.isEmpty() ) return true;
        return false;
    }
}