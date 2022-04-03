package calculator.engine.calculate;

import calculator.engine.model.OperatorOrder;

import java.util.List;

public interface Calculate {
    double calculate(Double[] nums, List<OperatorOrder> orderedOperators);
}
