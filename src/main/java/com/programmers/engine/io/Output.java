package com.programmers.engine.io;

public interface Output  {
    void inputError();
    <T> void outputData(T data);
}
