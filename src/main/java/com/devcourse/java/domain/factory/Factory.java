package com.devcourse.java.domain.factory;

public interface Factory<T, P> {
    T create(P parameter);
}
