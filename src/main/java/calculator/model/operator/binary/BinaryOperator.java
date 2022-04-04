package calculator.model.operator.binary;

import calculator.model.operator.Operator;
import calculator.model.operator.OperatorType;

public interface BinaryOperator extends Operator, BinaryCalculable {
    boolean hasLowerPriority(BinaryOperator other);
    OperatorType getOperatorType();
}
