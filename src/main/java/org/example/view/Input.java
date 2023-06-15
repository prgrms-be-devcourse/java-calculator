package org.example.view;

import java.util.Optional;

public interface Input {
    Optional<SelectTypeView> select();
    String inputExpression();
}
