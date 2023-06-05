package programmers.java.calulator.console.command;

import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.console.repository.Repository;
import programmers.java.calulator.common.Calculator;

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