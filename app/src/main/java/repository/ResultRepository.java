package repository;

import model.Expression;

import java.util.*;

public class ResultRepository {

    public static Map<Long, Expression> db = new HashMap<>();

    public void save(Expression expression) {
        db.put(expression.getId(), expression);
    }

    public List<Expression> findAll() {
        return new ArrayList<>(db.values());
    }

}
