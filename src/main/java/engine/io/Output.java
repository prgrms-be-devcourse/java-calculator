package engine.io;

import engine.model.Function;

public interface Output {
    void outputFunction(Function function);

    void inputFunctionError();

    void inputExpressionError();
}
