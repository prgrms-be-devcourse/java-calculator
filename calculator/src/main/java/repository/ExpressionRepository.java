package repository;

import entity.Expression;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ExpressionRepository extends Repository<AtomicLong,Expression> {

    private ExpressionRepository(){
        super(new LinkedHashMap<>(), new AtomicLong(0));
    };

    private static class ExpressionRepositoryHolder{
        private static final ExpressionRepository INSTANCE = new ExpressionRepository();
    }

    public static ExpressionRepository getInstance(){
        return ExpressionRepositoryHolder.INSTANCE;
    }

    @Override
    public Expression save (String input, double result) {
        id.incrementAndGet();

        Expression expression = new Expression(input,result);
        storage.put(id ,expression);
        return expression;
    }

    @Override
    public List<Expression> findAll() {
        return new ArrayList<>(storage.values());
    }
}
