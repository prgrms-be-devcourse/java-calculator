package programmers.java.calulator.common.command.impl;

import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.command.factory.CommandType;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.History;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.console.repository.MapHistory;
import programmers.java.calulator.common.calculator.Calculator;

public class ExecuteCalculationCommand implements Command {
    private final Calculator calculator;
    private final Reader reader;
    private final Writer writer;
    private final Repository repository;

    public ExecuteCalculationCommand(Calculator calculator, Reader reader, Writer writer, Repository repository) {
        this.calculator = calculator;
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
    }

    @Override
    public void execute() {
        String expression = reader.readLine();
        Integer result = calculator.calculate(expression);
        History history = new MapHistory(expression, result);
        repository.save(history);
        writer.write(result.toString());
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.EXECUTE_CALCULATION;
    }
}
