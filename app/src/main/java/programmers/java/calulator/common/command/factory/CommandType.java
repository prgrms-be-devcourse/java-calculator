package programmers.java.calulator.common.command.factory;

import programmers.java.calulator.common.calculator.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.common.command.impl.ExecuteCalculationCommand;
import programmers.java.calulator.common.command.impl.PrintHistoryCommand;
import programmers.java.calulator.console.repository.MapRepository;

public enum CommandType {
    PRINT_HISTORY("1", (writer, calculator, reader, repository) -> new PrintHistoryCommand(writer, repository)),
    EXECUTE_CALCULATION("2", (writer, calculator, reader, repository) -> new ExecuteCalculationCommand(calculator, reader, writer, repository));

    private final String command;
    private final CommandCreator creator;

    CommandType(String command, CommandCreator creator) {
        this.command = command;
        this.creator = creator;
    }

    public String getCommand() {
        return command;
    }

    public Command createCommand(Writer writer, Calculator calculator, Reader reader, Repository repository) {
        return creator.create(writer, calculator, reader, repository);
    }

    @FunctionalInterface
    private interface CommandCreator {
        Command create(Writer writer, Calculator calculator, Reader reader, Repository repository);
    }
}
