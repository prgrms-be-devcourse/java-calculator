package com.programmers.calculator.view;

import com.programmers.calculator.controller.io.Request;
import com.programmers.calculator.controller.io.Response;

public interface View {

    void show();

    Request read();

    void write(Response response);

}
