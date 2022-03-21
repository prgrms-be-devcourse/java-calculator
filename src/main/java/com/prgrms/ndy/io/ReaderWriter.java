package com.prgrms.ndy.io;

import java.io.IOException;

public interface ReaderWriter extends AutoCloseable {

    String read() throws IOException;

    void write(String s) throws IOException;

    void close() throws IOException;
}
