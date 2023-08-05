package programmers.java.calulator.common.command.impl;

import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.command.factory.CommandType;
import programmers.java.calulator.common.repository.History;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;

public class PrintHistoryCommand implements Command {
    private final Repository repository;
    private final Writer writer;

    public PrintHistoryCommand(Writer writer, Repository repository) {
        this.repository = repository;
        this.writer = writer;
    }

    @Override
    public void execute() {
        repository.findAll()
                .stream()
                .forEach(history -> writer.write(history.getExpression() + History.HISTORY_FORMAT_DELIMITER + history.getResult()));
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.PRINT_HISTORY;
    }
}

