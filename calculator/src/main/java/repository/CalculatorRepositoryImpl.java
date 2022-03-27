package repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculatorRepositoryImpl implements CalculatorRepository {
    private final Map<String,Integer> db = new LinkedHashMap<>();

    @Override
    public void save(String exp, int result) {
        db.put(exp,result);
    }

    @Override
    public int getResult(String exp) {
        return db.get(exp);
    }

    @Override
    public List<String> getResults() {
        return db.entrySet()
                .stream()
                .map(e-> e.getKey()+ "=" + e.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        db.clear();
    }
}
