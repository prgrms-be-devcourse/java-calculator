package calculator.application.io;

import calculator.application.io.enums.Message;
import calculator.engine.model.UserSelection;

import java.util.List;

public class Console implements Input, Output{
    private final Reader reader = new Reader();
    private final Printer printer = new Printer();

    @Override
    public UserSelection getUserSelection(List<String> literals) {
        printer.printLiterals(literals);
        printer.print(Message.SELECT);

        return reader.readSelection();
    }
}
