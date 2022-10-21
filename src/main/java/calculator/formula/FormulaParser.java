package calculator.formula;

import java.util.List;

public interface FormulaParser {
    List<String> parseFrom(String formula);
}
