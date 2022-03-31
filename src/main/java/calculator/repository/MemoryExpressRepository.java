package calculator.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryExpressRepository implements ExpressRepository {

    private static final Map<String, Integer> store = new LinkedHashMap<>();

    @Override
    public void save(String exp, int answer) {
        store.put(exp, answer);
    }

    @Override
    public int findByExpress(String exp) {
        return store.get(exp);
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
