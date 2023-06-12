package programmers.java.calulator.common.command.impl;

import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.command.factory.CommandType;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.console.repository.MapRepository;

import java.util.List;
import java.util.Map;

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
                .forEach(history -> writer.write(history.toString()));
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.PRINT_HISTORY;
    }
}

