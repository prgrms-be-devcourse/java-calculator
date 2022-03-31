package repository;

import model.Expression;

import java.util.*;

public class ResultRepository {


    private static Map<Long, Expression> db = new HashMap<>();

    public void save(Expression expression) {
        // 저장 로직
        db.put(expression.getId(), expression);
    }

    public void showRecord() {
        Iterator<Long> expKey = db.keySet().iterator();

        while (expKey.hasNext()) {
            Long key = expKey.next();
            System.out.println(db.get(key).getExpressionWithResult());
        }
    }
}
