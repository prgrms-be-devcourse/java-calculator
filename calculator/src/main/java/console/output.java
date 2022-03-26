package console;

import entity.Expression;

import java.io.IOException;
import java.util.List;

public interface output {

    void printPrompt() throws IOException;
    void printResultNum(double result) throws IOException;
    void printAllHistories(List<Expression> histories) throws IOException;
    void printExitCall() throws IOException;
    void printNewLine() throws IOException;

    // Error
    void printCmdFormatError() throws IOException;
    void printCmdTypeError() throws IOException;
    void printExpressionError() throws IOException;
    void printHistoryEmptyError() throws IOException;


}
