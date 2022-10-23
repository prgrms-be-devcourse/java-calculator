package calculator.calculator.notation.calculation;

import java.math.BigDecimal;
import java.util.List;

public interface NotationCalculation {
    BigDecimal calculate(List<String> formulas);
}
