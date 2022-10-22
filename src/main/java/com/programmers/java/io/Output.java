package com.programmers.java.io;

import com.programmers.java.data.Result;

public interface Output {
    void output(Result res);

    void error();

    void outputAnswer(Result calculate);
}
