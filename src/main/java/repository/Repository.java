package repository;

import model.Result;

import java.util.List;

public interface Repository {
    void save(Result result);
    List<Result> findAll();
}
