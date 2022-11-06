package app.storage;

import app.calculator.Answer;
import app.calculator.Expression;

import java.util.LinkedHashMap;
import java.util.Map;

// Map 타입의 저장소로 키에는 연산식을, 값에는 답을 저장합니다.
public class MapStorage implements Storage {

    private static final Map<String, Answer> storage = new LinkedHashMap<>();

    @Override
    public String save(Expression expression, Answer answer) {
        if (!existExpression(expression)) storage.put(expression.getExpressionValue(), answer);
        return expression.getExpressionValue() + " = " + answer.getCorrectAnswer();
    }

    @Override
    public String findAll() {
        StringBuilder stringBuilder = new StringBuilder();

        storage.forEach((expression, answer) ->
                stringBuilder.append(expression).append(" = ").append(answer.getCorrectAnswer()).append("\n"));

        return stringBuilder.toString();
    }

    @Override
    public void removeAll() {
        storage.clear();
    }

    public boolean existExpression(Expression expression) {
        return storage.containsKey(expression.getExpressionValue());
    }

    public Answer getExistAnswer(Expression expression) {
        return storage.get(expression.getExpressionValue());
    }
}
