package org.example.io;

import java.io.IOException;

public interface Input {
    String selectAction() throws IOException;

    String input() throws IOException;
}
