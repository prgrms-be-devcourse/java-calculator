package com.programmers.calculator.controller;

import com.programmers.calculator.controller.io.Request;
import com.programmers.calculator.controller.io.Response;

public interface Controller {

    Response inquiry();

    Response calculate(Request request);

}
