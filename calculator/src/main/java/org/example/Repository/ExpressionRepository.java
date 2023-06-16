package org.example.Repository;

import java.util.ArrayList;
import java.util.List;

public class ExpressionRepository implements Repository {
    private static List<String> store = new ArrayList<>();

    @Override
    public void save(String expression, int result) {
        store.add(expression + " = " + result);
    }

    @Override
    public List<String> getRecords() {
        return store;
    }
}
