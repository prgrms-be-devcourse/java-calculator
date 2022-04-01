package engine.io;

import engine.model.Function;
import engine.model.Record;

public interface Output {
    void printFunction(Function function);

    void inputFunctionError();

    void inputExpressionError();

    void outputCalculateAnswer(int answer);

    void printRecord(Record record);
}
