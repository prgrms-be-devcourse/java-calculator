package com.calculator.repository;

import com.calculator.entity.Expression;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapRepository implements Repository {

    // key는 1부터 시작 (idx)
    private Map<Integer, Expression> map = new HashMap<>();

    @Override
    public int findAll() {
        Collection<Expression> values = map.values();

        values.forEach(System.out::println);
        return values.size();
    }

    /**
     * 효율성 측면에서 어떻게 개선시킬 수 있을까요?
     * map의 구조를 어떻게 변경하면 좋을지 궁금합니다!
     */
    @Override
    public Expression findByInfix(String infix) {
        Collection<Expression> values = map.values();

        Optional<Expression> first = values.stream()
                .filter((e) -> e.getInfix().equals(infix))
                .findFirst();

        if (first.isEmpty()) {
            return null;
        } else {
            return first.get();
        }
    }

    /**
     * @param expression
     * @return map key 번호
     */
    @Override
    public int save(Expression expression) {
        // map에 이미 존재하는 객체가 들어올 수도 있음
        // 한번더 저장!
        map.put(map.size() + 1, expression);
        return map.size();
    }
}
