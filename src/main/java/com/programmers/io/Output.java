package com.programmers.io;

public interface Output {

    <T> void println(T msg);

    <T> void print(T msg);

    void printErrorMsg(String errMsg);

}
