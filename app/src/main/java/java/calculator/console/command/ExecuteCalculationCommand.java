package java.calculator.console.command;

import java.calculator.common.Calculator;
import java.calculator.common.command.Command;
import java.calculator.common.reader.Reader;
import java.calculator.common.writer.Writer;
import java.calculator.console.repository.Repository;

public class ExecuteCalculationCommand implements Command {
    private final Calculator calculator;
    private final Reader reader;
    private final Writer writer;

    public ExecuteCalculationCommand(Calculator calculator, Reader reader, Writer writer) {
        this.calculator = calculator;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void execute() {
        String expression = reader.readLine();
        int result = calculator.calculate(expression);
        Repository.getInstance().add(expression, result);
        writer.write(Integer.toString(result));
    }
}