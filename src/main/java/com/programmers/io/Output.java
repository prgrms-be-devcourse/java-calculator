package com.programmers.io;

import java.util.Map;

public interface Output {

    <T> void println(T msg);

    <T> void print(T msg);

    void printResult(Map<String, Double> map);

    void printErrorMsg(String errMsg);

}
