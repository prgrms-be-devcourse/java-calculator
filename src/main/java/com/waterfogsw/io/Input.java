package com.waterfogsw.io;

import java.io.IOException;

public interface Input {
    int inputMenu(String prompt) throws IOException;

    String inputExpr(String prompt) throws IOException;
}
