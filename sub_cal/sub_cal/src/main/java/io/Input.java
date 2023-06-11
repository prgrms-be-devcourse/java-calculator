package io;

import option.Option;

public interface Input {

    Option selectOption(String selectMessage);

    String inputString();
}
