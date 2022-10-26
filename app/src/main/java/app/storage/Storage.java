package app.storage;

import app.calculator.Answer;

public interface Storage {
    String save(String expression, Answer answer);

    String findAll();

    void removeAll();
}
