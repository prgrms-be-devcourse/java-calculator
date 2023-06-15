package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class HistoryStorage {
    private static final String STORAGE_EMPTY_MESSAGE = "연산 기록이 없습니다.";
    private final Map<Integer, String> storage;
    private int id = 0;

    public HistoryStorage() {
        this.storage = new LinkedHashMap<>();
    }

    public void save(String expression, String result) {
        String formattedExpression = makeFormattedExpression(expression, result);
        storage.put(id, formattedExpression);
        id++;
    }

    public String loadAll() {
        if (storage.isEmpty()) {
            return STORAGE_EMPTY_MESSAGE;
        }

        return String.join("\n", storage.values());
    }

    private String makeFormattedExpression(String expression, String result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char expressionComponent : expression.toCharArray()) {
            stringBuilder.append(expressionComponent).append(' ');
        }
        stringBuilder.append("= ").append(result);

        return stringBuilder.toString();
    }
}
