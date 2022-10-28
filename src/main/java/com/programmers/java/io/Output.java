package com.programmers.java.io;

import com.programmers.java.data.Result;

public interface Output {
    void putResult(String s);

    void putError(String e);

    void putAnswer(Double d);

    void putEnd();
}
