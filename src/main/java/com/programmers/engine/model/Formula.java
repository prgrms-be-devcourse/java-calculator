package com.programmers.engine.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

@Setter @Getter
public class Formula {
    private LinkedList<String> content;
    private StringBuilder sb = new StringBuilder();
    // 순차적으로 접근할 것 이기때문에 LinkedList 로 구현
    public void addData(DataBase db, int result){
        for (String s : content) sb.append(s);
        sb.append(" = "); sb.append(result); // 결과 포함해서 저장
        db.addData(sb.toString()); // Stream 으로 바꿀예정
        sb.setLength(0); // 길이를 0으로 설정해서 저장: 새로 선언하는 것 보다 시간이 절약됨
        // LinkedList 를 하나의 스트링으로 저장
    }
    public void clearContent(){content.clear();};
    public void makeFormula(String s){
        String[] tmp = s.split(" ");
        content.addAll(Arrays.asList(tmp));
    }
}
