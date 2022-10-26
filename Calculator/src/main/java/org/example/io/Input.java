package org.example.io;

import java.io.IOException;

public interface Input {
    String selectMenu(String s) throws IOException;

    String input() throws IOException;
}
