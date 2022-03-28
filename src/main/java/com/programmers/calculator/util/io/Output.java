package com.programmers.calculator.util.io;

import com.programmers.calculator.exception.OutputException;

import java.util.List;

public interface Output<T> {
    void outputList(List<T> list) throws OutputException;
}
