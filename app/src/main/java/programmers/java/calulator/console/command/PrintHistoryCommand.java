package programmers.java.calulator.console.command;

import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.console.repository.MapRepository;
import java.util.Map;

public class PrintHistoryCommand implements Command {
    private final MapRepository repository;
    private final Writer writer;

    public PrintHistoryCommand(Writer writer, MapRepository repository) {
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

