package com.kimhunki.java.calculator.strategy;

import com.kimhunki.java.calculator.enums.MenuNumber;
import com.kimhunki.java.calculator.enums.Operations;

import java.util.List;

public interface ParserStrategy
{
    MenuNumber menuParser(String selectString);

    List<String> expressionParser(String expression);
}
