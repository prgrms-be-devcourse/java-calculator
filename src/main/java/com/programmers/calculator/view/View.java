package com.programmers.calculator.view;

import com.programmers.calculator.controller.io.ConsoleRequest;
import com.programmers.calculator.controller.io.ConsoleResponse;

public interface View {

    void show();

    ConsoleRequest read();

    void write(ConsoleResponse response);

}
