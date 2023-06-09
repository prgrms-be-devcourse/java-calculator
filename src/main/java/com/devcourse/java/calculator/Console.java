package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;

public class Console implements Input, Output {

    @Override
    public void printCommandMenu() {
        System.out.print(MenuConstant.REQUEST_COMMAND_INT);
    }

    @Override
    public int getCommand() {
        return 0;
    }
}
