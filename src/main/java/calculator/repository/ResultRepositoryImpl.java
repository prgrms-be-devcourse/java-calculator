package calculator.repository;

public class ResultRepositoryImpl implements ResultRepository {

    private static ResultRepository repository = new ResultRepositoryImpl();

    private ResultRepositoryImpl() {
    }

    public static ResultRepository getInstance() {
        return repository;
    }

    @Override

    public Boolean isCalculated(String expr) {
        return null;
    }

    @Override
    public Integer getResult(String expr) {
        return null;
    }

    @Override
    public void saveResult(String expr) {

    }
}
