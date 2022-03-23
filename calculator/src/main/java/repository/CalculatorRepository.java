package repository;

import entity.Expression;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CalculatorRepository implements MemoryRepository {

    private static final Map<Long, Expression> historyMap = new ConcurrentHashMap<>();
    private static AtomicLong id = new AtomicLong(1L);

    @Override
    public Expression save (String input, double result) {
        Expression expression = new Expression(id.get(),input,result);
        historyMap.put(id.getAndIncrement(),expression);
        return expression;
    }

    @Override
    public List<Expression> findAll() {
        return new ArrayList<>(historyMap.values());
    }
}
