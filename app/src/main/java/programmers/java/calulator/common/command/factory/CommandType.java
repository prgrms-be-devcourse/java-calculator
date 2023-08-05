package programmers.java.calulator.common.command.factory;

import programmers.java.calulator.common.calculator.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.common.command.impl.ExecuteCalculationCommand;
import programmers.java.calulator.common.command.impl.PrintHistoryCommand;

public enum CommandType {
    PRINT_HISTORY("1", "조회", (writer, calculator, reader, repository) -> new PrintHistoryCommand(writer, repository)),
    EXECUTE_CALCULATION("2", "계산", (writer, calculator, reader, repository) -> new ExecuteCalculationCommand(calculator, reader, writer, repository));

    private final String command;
    private final String description;
    private final CommandCreator creator;

    CommandType(String command, String description, CommandCreator creator) {
        this.command = command;
        this.description = description;
        this.creator = creator;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    public Command createCommand(Writer writer, Calculator calculator, Reader reader, Repository repository) {
        return creator.create(writer, calculator, reader, repository);
    }

    @FunctionalInterface
    private interface CommandCreator {
        Command create(Writer writer, Calculator calculator, Reader reader, Repository repository);
    }
}
