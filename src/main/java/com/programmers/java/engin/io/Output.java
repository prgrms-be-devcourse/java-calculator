package com.programmers.java.engin.io;

import com.programmers.java.engin.model.Log;

import java.util.List;

public interface Output {
    void logsView(List<Log> logs);

    void answer(String result);

    void errorMessage(String err);
}
