package engine.model;

import java.util.ArrayList;
import java.util.Optional;

public class Record {
    private ArrayList<String> record;

    public void addRecord(String expression, int answer) {
        Optional<ArrayList<String>> record = Optional.ofNullable(this.record);
        if (record.isEmpty()) this.record = new ArrayList<String>();
        this.record.add(expression + " = " + answer);
    }

    public void printRecord() {
        Optional<ArrayList<String>> record = Optional.ofNullable(this.record);
        if (record.isEmpty()) System.out.println("계산 기록이 없습니다.");
        record.ifPresent(strings -> strings.forEach(System.out::println));
    }
}
