package calculator.config;

import calculator.Console;
import calculator.repository.CalculationRepository;
import calculator.repository.ListRepository;
import calculator.service.*;
import calculator.serviceImpl.*;

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
        return new CalculateImpl(sorter());
    }

    public CalculationRepository calculationRepository() {
        return new ListRepository();
    }


    public CalculationServiceImpl calculationService() {
        return new CalculationServiceImpl(
                calculationRepository(),
                parser(),
                calculation()
        );
    }
}
