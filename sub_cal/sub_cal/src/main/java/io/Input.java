package io;

import option.Option;

import java.io.IOException;

public interface Input {

    Option selectOption();

    String inputString() throws IOException;
}
