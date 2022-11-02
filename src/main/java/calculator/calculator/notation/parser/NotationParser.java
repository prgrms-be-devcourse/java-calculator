package calculator.calculator.notation.parser;

import calculator.calculator.formula.Formula;

public interface NotationParser {
    Formula parseFrom(Formula formulas);
}
