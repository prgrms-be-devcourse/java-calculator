package com.programmers.engine.caculator;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public interface Caculator {
    public  void caculate(List<String> operatorAndNumbers);
    public boolean isSucessfull();
    public String getResult();
}
