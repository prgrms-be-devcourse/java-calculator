package com.programmers.java.data;

import com.programmers.java.io.Output;

public interface Repository {
    void save(Result res);

    boolean contain(String s);

    Double getOneResult(String s);

    void getAllResult(Output output);
}
