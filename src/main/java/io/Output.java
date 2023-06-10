package io;

import model.Result;

import java.util.List;

public interface Output {
    void inputError(String message);
    void results(List<Result> results);
    void answer(Result result);
}