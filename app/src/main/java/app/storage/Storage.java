package app.storage;

import app.calculator.Answer;
import app.calculator.Expression;

import java.util.Optional;

public interface Storage {
    String save(Expression expression, Answer answer);

    String findAll();

    void removeAll();

    default Optional<Answer> checkStorageAndFindAnswer(Storage storage, Expression expression) {
        if (storage instanceof MapStorage && ((MapStorage) storage).existExpression(expression)) {
            return Optional.of(((MapStorage) storage).getExistAnswer(expression));
        }
        return Optional.empty();
    }
}
