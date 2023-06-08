package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Storage;
import com.devcourse.java.domain.calculateResult.CalculateResult;
import com.devcourse.java.domain.console.Console;

public class Calculate implements Menu {
    private final Storage<CalculateResult> storage;

    public Calculate(Storage storage) {
        this.storage = storage;
    }

    @Override
    public boolean execute(Console console) {
        String expression = console.readExpression(); // 유효성 검사
        return true;
    }
}
