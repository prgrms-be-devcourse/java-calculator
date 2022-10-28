package com.project.java.engine.io;

import java.io.IOException;

public interface Input {
    String getInput(String message) throws IOException;
    String getExpression(String message) throws IOException;
    boolean validateInput(String input);
}
