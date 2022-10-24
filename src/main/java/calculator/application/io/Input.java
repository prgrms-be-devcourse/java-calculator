package calculator.application.io;

import calculator.application.model.UserSelection;
import calculator.engine.model.Expression;

import java.util.List;

public interface Input {

    UserSelection getUserSelection(List<String> literals);

    Expression getExpression();
}
