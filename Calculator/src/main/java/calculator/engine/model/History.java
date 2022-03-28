package calculator.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@AllArgsConstructor
@Getter
public class History {
    private String formula;
    private double calculation;
}
