package com.devcourse.java.common;

public interface Factory<T, P> {
    T create(P parameter);
}
