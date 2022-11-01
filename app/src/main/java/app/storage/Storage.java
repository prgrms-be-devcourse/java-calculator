package app.storage;

import app.calculator.Answer;
import app.calculator.Expression;

public interface Storage {
    String save(Expression expression, Answer answer);

    String findAll();

    void removeAll();
}
