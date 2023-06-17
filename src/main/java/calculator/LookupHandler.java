package calculator;

import calculator.handler.ILookupHandler;
import calculator.model.Result;
import calculator.respository.Repository;

import java.util.List;

public class LookupHandler implements ILookupHandler {

    private final Repository repository;

    public LookupHandler(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Result> lookup() {
        return repository.findAll();
    }
}
