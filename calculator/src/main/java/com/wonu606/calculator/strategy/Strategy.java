package com.wonu606.calculator.strategy;

import com.wonu606.calculator.storage.Persistence;
import com.wonu606.io.Input;
import com.wonu606.io.Print;

public interface Strategy {

    void execute(Input input, Print printer, Persistence store);
}
