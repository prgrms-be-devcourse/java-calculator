package repository;

import model.Expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryExpressionRepository implements ExpressionRepository {
    private static Map<Long, Expression> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(Expression expression) {
        store.put(sequence, expression);
        sequence++;
    }

    @Override
    public List<Expression> findAll() {
        return new ArrayList<>(store.values());
    }
}
