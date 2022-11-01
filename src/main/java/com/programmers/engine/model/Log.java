package com.programmers.engine.model;

import com.programmers.Console;
import com.programmers.engine.io.Output;

import java.math.BigDecimal;

public class Log {
    private String formula;
    private BigDecimal result;
    private Output output;

    public Log(String formula, BigDecimal result) {
        this.formula = formula;
        this.result = result;
        this.output = new Console();
    }
    public void show(){
        output.simplePrint(formula + " = " + result);
    }
}
