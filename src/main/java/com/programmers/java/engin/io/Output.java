package com.programmers.java.engin.io;

import com.programmers.java.engin.model.Logs;

public interface Output {
    void logView(Logs logs);

    void answer(int result);

    void errorMessage(String s);
}
