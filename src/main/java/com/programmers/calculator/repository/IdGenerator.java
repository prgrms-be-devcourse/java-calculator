package com.programmers.calculator.repository;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private AtomicLong id = new AtomicLong();

    private IdGenerator(){}

    public static IdGenerator getInstance() {
        return LazyHolderIdGenerator.INSTANCE;
    }

    public Long generateId() {
        return id.getAndIncrement();
    }

    private static class LazyHolderIdGenerator {
        private static final IdGenerator INSTANCE = new IdGenerator();
    }

}
