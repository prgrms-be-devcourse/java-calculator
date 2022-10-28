package com.programmers.engine.io;

import com.programmers.engine.model.DataBase;

import java.util.LinkedList;

public interface Output {
    void showAll(LinkedList<String> l);

    void inputError();

    void bye();


    void wrongChoice();

    void numOperatorValidationError();

    void bracketValidationError();

    void caution();

    void divdeByZeroError();

    void dbNoDate();
}
