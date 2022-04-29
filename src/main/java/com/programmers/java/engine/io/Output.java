package com.programmers.java.engine.io;

public interface Output {
    void informFormat();

    void errorMessage(Exception e);

    void exitMessage();
}
