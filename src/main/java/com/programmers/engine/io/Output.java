package com.programmers.engine.io;

import com.programmers.engine.model.DataBase;

public interface Output {
    void showAll(DataBase db);

    void inputError();

    void bye();


    void wrongChoice();

    void numOperatorValidationError();

    void bracketValidationError();

    void caution();
}
