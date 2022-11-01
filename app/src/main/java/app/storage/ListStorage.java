package app.storage;

import app.calculator.Answer;
import app.calculator.Expression;

import java.util.LinkedList;
import java.util.List;

// LinkedList 타입의 저장소
public class ListStorage implements Storage{

    private static final List<String> storage = new LinkedList<>();

    // 저장소에 값을 저장합니다.
    @Override
    public String save(Expression expression, Answer answer) {
        storage.add(expression.getExpressionValue() + " = " + answer.getCorrectAnswer());

        return storage.get(storage.size() - 1);
    }

    // 저장소의 모든 데이터를 String으로 반환합니다.
    @Override
    public String findAll() {
        StringBuilder stringBuilder = new StringBuilder();

        storage.forEach(history -> stringBuilder.append(history).append("\n"));

        return stringBuilder.toString();
    }

    // 테스트 코드를 위해서 저장소의 모든 데이터를 삭제합니다.
    @Override
    public void removeAll() {
        storage.clear();
    }
}
