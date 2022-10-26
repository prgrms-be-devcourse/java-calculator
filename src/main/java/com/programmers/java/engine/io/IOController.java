package com.programmers.java.engine.io;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class IOController {
    protected InputStream reader;
    protected OutputStream writer;

    public IOController(InputStream reader, OutputStream writer) {
        this.reader = reader;
        this.writer = writer;
    }

    abstract public String read();

    abstract public void print(Object message);
}
