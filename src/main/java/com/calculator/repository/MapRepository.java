package com.calculator.repository;

import com.calculator.entity.Expression;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Getter
public class MapRepository implements Repository {

    private Map<Integer, Expression> map = new HashMap<>();

    public void forEach(Consumer<Expression> consumer) {
        for (int i = 0; i < map.size(); i++) {
            consumer.accept(map.get(i));
        }
    }

    @Override
    public void findAll() {
        forEach(System.out::println);
    }

    @Override
    public Expression findById(int id) {
        return null;
    }

    @Override
    public int save(Expression expression) {
        return 0;
    }
}
