package app.storage;

import app.calculator.Answer;

import java.util.HashMap;
import java.util.Map;

// Map 타입의 저장소로 키에는 1부터 순차적으로 증가하는 id를, 값에는 연산식과 답을 저장합니다.
public class MapStorage implements Storage {

    private static final Map<Long, String> storage = new HashMap<>();
    private static long sequence = 1L;

    @Override
    public String save(String expression, Answer answer) {
        String saveValue = expression + " = " + answer.getCorrectAnswer();
        storage.put(sequence++, saveValue);
        return saveValue;
    }

    @Override
    public String findAll() {
        StringBuilder stringBuilder = new StringBuilder();

        storage.values()
                .forEach(history -> stringBuilder.append(history).append("\n"));

        return stringBuilder.toString();
    }

    @Override
    public void removeAll() {
        storage.clear();
    }
}
