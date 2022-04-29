package com.programmers.java.engine.model;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

/*
 * History : 계산 이력을 관리
 * - 멤버 변수 history를 Calculator의 member로 두지 않고 History 클래스를 따로 만든 이유
 * 1. Calculator 내에서 이미 완료된 history 데이터에 대한 변경을 하지 못하도록 강제하기 위함
 * 2. history에 관한 기능 확장성 고려
 * - 고민 : "아직 계산한 이력이 없습니다" 부분 출력을 그대로 두는것이 맞다 vs 출력이므로 output으로 관리해야한다.
 * */
@AllArgsConstructor
public class History {
    private ArrayList<Expression> history;

    public void save(Expression e) {
        history.add(e);
    }

    public String searchAll() {
        if (history.isEmpty()) return "아직 계산한 이력이 없습니다.";

        StringBuilder sb = new StringBuilder();
        for (Expression expression : history) {
            sb.append(expression).append("\n");
        }
        return sb.toString();
    }
}
