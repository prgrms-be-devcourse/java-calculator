package repository;

import entity.Expression;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRepository implements CalculatorRepository {

    private static final Map<Long, Expression> historyMap = new ConcurrentHashMap<>();
    private static AtomicLong id = new AtomicLong(1L);

    /**
     * 객체를 저장하는데, 이게 클래스의 구조와 파라미터가 어울리는지...
     * 3.27
     * */
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
