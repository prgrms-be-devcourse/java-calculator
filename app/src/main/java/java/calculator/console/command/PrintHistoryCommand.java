package java.calculator.console.command;

import java.calculator.common.command.Command;
import java.calculator.common.writer.Writer;
import java.calculator.console.repository.Repository;
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
        for (Map.Entry<String, Integer> entry : repository.getRepository().entrySet()) {
            writer.write(entry.getKey() + " = " + entry.getValue());
        }
    }
}

