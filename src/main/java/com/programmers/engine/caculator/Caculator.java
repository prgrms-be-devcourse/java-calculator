package com.programmers.engine.caculator;

import com.programmers.engine.model.CaculatorParseData;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public interface Caculator {
    public  void caculate(CaculatorParseData operatorAndNumbers);
    public String getResult() throws Exception;
}
