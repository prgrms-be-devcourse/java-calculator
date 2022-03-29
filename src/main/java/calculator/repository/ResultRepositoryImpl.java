package calculator.repository;

import java.util.Hashtable;
import java.util.Map;

public class ResultRepositoryImpl implements ResultRepository {

    private static final ResultRepositoryImpl repository = new ResultRepositoryImpl();
    private final Map<String, Integer> history; // history of calculation

    private ResultRepositoryImpl() {
        history = new Hashtable<>();
    }

    public static ResultRepositoryImpl getInstance() {
        return repository;
    }

    @Override

    public Boolean isCalculated(String expr) {
        return history.containsKey(expr);
    }

    @Override
    public Integer getResult(String expr) {
        return history.get(expr);
    }

    @Override
    public void saveResult(String expr, Integer resultOfExpr) {
        history.put(expr, resultOfExpr);
    }

    @Override
    public void printAll() {
        for(String key: history.keySet()) {
            System.out.println(key + " = " + history.get(key));
        }
        System.out.println();
    }

    /**
     * test를 위한 method
     */
    public void clearAll() {
        history.clear();
    }

    public Integer size() {
        return history.size();
    }
}
