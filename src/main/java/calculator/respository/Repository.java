package calculator.respository;

import calculator.model.Result;

import java.util.List;

public interface Repository {
    void save(Result result);
    List<Result> findAll();
}
