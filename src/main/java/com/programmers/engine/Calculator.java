package com.programmers.engine;

import com.programmers.engine.io.*;
import com.programmers.engine.model.*;
import com.programmers.engine.stack.*;

public class Calculator implements Runnable{

    private Input input;
    private Output output;

    private DataBase dataBase;

    private Formula formula;

    private MyStack numStack = new NumStack();
    private MyStack operatorStack = new OperatorStack();

    @Override
    public void run() {
        // do something
    }
}
