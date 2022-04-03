package calculator.config;

import calculator.engine.calculate.Calculate;
import calculator.engine.calculate.CalculateImpl;
import calculator.Console;
import calculator.engine.parser.BasicParser;
import calculator.engine.parser.Parser;
import calculator.engine.sorter.BasicSorter;
import calculator.engine.sorter.Sorter;
import calculator.repository.CalculationRepository;
import calculator.repository.ListRepository;

public class AppConfig {

    public Console console() {
        return new Console();
    }

    public Sorter sorter() {
        return new BasicSorter();
    }

    public Parser parser() {
        return new BasicParser();
    }

    public Calculate calculation() {
        return new CalculateImpl();
    }

    public CalculationRepository calculationRepository() {
        return new ListRepository();
    }
}
