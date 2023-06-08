package model;

import java.util.ArrayList;
import java.util.List;
// 계산 내역을 저장하고 출력합니다.
public class History {
    // 계산 내역을 저장하는 리스트
    static List<String> log = new ArrayList<>();
    public boolean isEmpty() {
        return log.isEmpty();
    }
    // 외부에서 계산 내역을 조회할려고 하면 실행합니다
    public void getHistory() {
        for (String s : log) {
            System.out.println(s);
        }
    }
    // 저장된 계산 내역 개수를 반환합니다
    public Integer getHistoryLen() {
        return log.size();
    }
    // 계산 내역을 추가합니다
    public void addHistory(String result){
        log.add(result);
    }
}
