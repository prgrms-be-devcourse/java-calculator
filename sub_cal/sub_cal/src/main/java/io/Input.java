package io;

import option.Option;

import java.io.IOException;

public interface Input {

    Option selectOption() throws IOException;

    String inputString() throws IOException;
}