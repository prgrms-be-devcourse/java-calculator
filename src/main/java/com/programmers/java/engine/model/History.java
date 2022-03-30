package com.programmers.java.engine.model;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

//ArrayList<Expression> history를 Calculator의 member가 아닌 클래스로 따로 뺀 이유
// : Calculator 내에서 이미 완료된 history 변경 못하게 하기 위함, history에 관한 기능들 확장 가능성 고려.

@AllArgsConstructor
public class History {
    private ArrayList<Expression> history;

    public void save(Expression e){
        history.add(e);
    }

    public void searchAll(){
        for(int i=0; i<history.size(); i++){
            System.out.println(history.get(i));
        }
    }
}
