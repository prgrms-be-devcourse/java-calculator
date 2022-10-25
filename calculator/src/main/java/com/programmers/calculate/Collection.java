package com.programmers.calculate;

import java.util.List;
import java.util.function.Consumer;

public class Collection<T> {
    private List<T> list;

    public Collection(List<T> list) {
        this.list = list;
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < list.size(); i++) {
            T data = list.get(i);
            consumer.accept(data);
        }
    }
}
