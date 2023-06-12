package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 계산 내역을 저장하고 출력합니다.
public class History {
    // 계산 내역을 저장하는 리스트
    private List<String> log = new ArrayList<>();
    public boolean isEmpty() {
        return log.isEmpty();
    }
    // 외부에서 계산 내역을 조회할려고 하면 실행합니다
    public List<String> getHistory() {
        return log;
    }

    // 저장된 계산 내역 개수를 반환합니다
    public Integer getHistoryLen() {
        return log.size();
    }
    // 계산 내역을 추가합니다
    public void addHistory(String inputString,int result){
        StringBuilder sb = new StringBuilder();
        log.add(sb.append(inputString).append(" = ").append(result).toString());
    }
}
