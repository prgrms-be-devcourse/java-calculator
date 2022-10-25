package org.example.io;

import java.io.IOException;

public interface Input {
    int selectMenu(String s) throws IOException;

    String input() throws IOException;
}
