package com.kimhunki.java.calculator;

import com.kimhunki.java.calculator.engine.Selector;
import com.kimhunki.java.calculator.io.Input;
import com.kimhunki.java.calculator.io.Output;

public class App
{
    public static void main(String[] args)
    {
        Console console = new Console();
        new Selector(console).run();
    }
}
