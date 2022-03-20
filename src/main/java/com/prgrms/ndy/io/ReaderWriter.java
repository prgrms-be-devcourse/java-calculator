package com.prgrms.ndy.io;

public interface ReaderWriter extends AutoCloseable {

    String read();

    void write(String s);

    void close();
}
