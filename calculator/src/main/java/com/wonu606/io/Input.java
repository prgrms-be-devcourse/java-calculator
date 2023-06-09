package com.wonu606.io;

import java.io.IOException;

public interface Input {

    String getInput() throws IOException;

    void tearDown();
}
