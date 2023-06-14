package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class History {
    // 계산 내역을 저장하는 리스트
    private List<String> log = new ArrayList<>();

    public List<String> getHistory() {
        return log;
    }

    // 저장된 계산 내역 개수를 반환합니다

    public void addHistory(String inputString,int result){
        StringBuilder sb = new StringBuilder();
        log.add(sb.append(inputString).append(" = ").append(result).toString());
    }
}
