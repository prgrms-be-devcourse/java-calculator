package programmers.java.calulator.console.menu;

import programmers.java.calulator.common.calculator.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.common.command.factory.CommandType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class MenuHandler {
    private final Writer writer;
    private final Map<String, Command> commands;
    private final Reader reader;
    private final Calculator calculator;
    private final Repository repository;

    public MenuHandler(Writer writer, Calculator calculator, Reader reader, Repository repository) {
        this.writer = writer;
        this.commands = new HashMap<>();
        this.reader = reader;
        this.calculator = calculator;
        this.repository = repository;
        initializeCommands();
    }

    private void initializeCommands() {
        Stream.of(CommandType.values()).forEach(commandType ->
                commands.put(commandType.getCommand(), commandType.createCommand(writer, calculator, reader, repository))
        );
    }

    public void printMenu() {
        writer.write("1. 조회");
        writer.write("2. 계산");
        writer.write("선택 : ");
    }

    public String readMenu() {
        return reader.readLine();
    }

    public Command getCommand(String menu) {
        return Optional.ofNullable(commands.get(menu))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
    }
}
