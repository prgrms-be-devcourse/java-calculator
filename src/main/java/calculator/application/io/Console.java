package calculator.application.io;

import calculator.application.io.enums.Message;
import calculator.application.model.UserSelection;
import calculator.engine.model.Expression;

import java.util.List;

public class Console implements Input, Output{
    private final Reader reader = new Reader();
    private final Printer printer = new Printer();

    @Override
    public UserSelection getUserSelection(List<String> literals) {
        printer.printLiterals(literals);
        printer.print(Message.INPUT_SELECT_GUIDE);
        return reader.readSelection();
    }

    @Override
    public Expression getExpression() {
        printer.print(Message.INPUT_EXPRESSION_GUIDE);
        return reader.readExpression();
    }
}
