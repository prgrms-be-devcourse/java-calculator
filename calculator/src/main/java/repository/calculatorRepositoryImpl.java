package repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class calculatorRepositoryImpl implements calculatorRepository{
    private final Map<String,Integer> db = new LinkedHashMap<>();

    @Override
    public void save(String exp, int result) {
        db.put(exp,result);
    }

    @Override
    public List<String> getResults() {
        return null;
    }

    @Override
    public void clear() {
        db.clear();
    }
}
