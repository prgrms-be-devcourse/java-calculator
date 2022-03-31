package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.io.Output;
import com.programmers.java.calculator.engine.model.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryStore {
    private final List<History> histories = new ArrayList<>();

    public void show(Output output) {
        //TODO : History를 이용한 조회 기능 구현하기
        for (History history : histories) {
            output.print(history.show());
        }
    }

    public void store(History history) {
        histories.add(history);
    }
}
