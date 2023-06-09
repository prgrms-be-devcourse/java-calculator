package com.wonu606.app;

import com.wonu606.io.Input;
import com.wonu606.io.Print;
import java.io.IOException;

public interface App {

    void execute(Input input, Print printer) throws IOException;
}
