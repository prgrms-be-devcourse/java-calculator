package calculator.io;

import calculator.model.Result;

import java.util.List;

public interface Output {
    void print(String output);
    void print(List<Result> list);
}
