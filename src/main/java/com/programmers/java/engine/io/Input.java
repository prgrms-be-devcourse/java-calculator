package com.programmers.java.engine.io;

import com.programmers.java.engine.Menu;
import com.programmers.java.engine.io.exception.WrongInputException;

import java.util.Optional;

public interface Input {
    Menu optionInput(String s) throws WrongInputException;

    String expressionInput(String s) throws WrongInputException;
}
