package programmers.java.calulator.console.menu;

import programmers.java.calulator.common.calculator.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.repository.Repository;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.common.command.factory.CommandType;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuHandler {
    private static final String MENU_ITEM_SEPARATOR = ". ";
    private final Writer writer;
    private final Map<String, Command> commands;
    private final Reader reader;
    private final Calculator calculator;
    private final Repository repository;

    public MenuHandler(Writer writer, Calculator calculator, Reader reader, Repository repository) {
        this.writer = writer;
        this.reader = reader;
        this.calculator = calculator;
        this.repository = repository;
        this.commands = initializeCommands();
    }

    private Map<String, Command> initializeCommands() {
        return Stream.of(CommandType.values())
                .collect(Collectors.toMap(CommandType::getCommand, commandType -> commandType.createCommand(writer, calculator, reader, repository)));
    }

    public void printMenu() {
        commands.values().forEach(command -> {
            CommandType commandType = command.getCommandType();
            writer.write(commandType.getCommand() + MENU_ITEM_SEPARATOR + commandType.getDescription());
        });
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
