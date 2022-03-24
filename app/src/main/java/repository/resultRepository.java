package repository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class resultRepository {
    Queue<String> resultQ = new LinkedList<>();

    public void save(String exp, String result) {
        // 저장 로직
        String recordedResult = exp + " " + " = " + result;
        resultQ.add(recordedResult);
    }

    public void showRecord() {
        while (!resultQ.isEmpty()) {
            System.out.println(resultQ.poll());
        }
    }
}
