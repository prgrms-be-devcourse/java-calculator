package programmers.java.calulator.console.runner;

import programmers.java.calulator.common.runner.ApplicationRunner;
import programmers.java.calulator.common.Calculator;
import programmers.java.calulator.common.command.Command;
import programmers.java.calulator.common.reader.Reader;
import programmers.java.calulator.common.writer.Writer;
import programmers.java.calulator.console.command.ExecuteCalculationCommand;
import programmers.java.calulator.console.command.PrintHistoryCommand;
import programmers.java.calulator.console.repository.MapRepository;
import java.util.Map;
import java.util.Optional;

public class ConsoleRunner implements ApplicationRunner {
    private final Calculator calculator;
    private final Reader reader;
    private final Writer writer;
    private final Map<String, Command> commands;

    public ConsoleRunner(Calculator calculator, Reader reader, Writer writer, Map<String, Command> commands) {
        this.calculator = calculator;
        this.reader = reader;
        this.writer = writer;
        this.commands = commands;

        commands.put("1", new PrintHistoryCommand(writer, MapRepository.getInstance()));
        commands.put("2", new ExecuteCalculationCommand(calculator, reader, writer));
    }

    @Override
    public void run() {
        while (true) {
            writer.write("1. 조회");
            writer.write("2. 계산");
            writer.write("선택 : ");
            String menu = reader.readLine();

            Optional.ofNullable(commands.get(menu))
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."))
                    .execute();

        }
    }
}
