package org.calculator.engine.io;

import java.util.Optional;

public interface Input {
    Optional<String> printCondition();

    String insertEquation();
}
