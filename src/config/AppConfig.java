package config;

import repository.CalculationRepository;
import repository.ListRepository;
import service.*;

public class AppConfig {
    public ValidationCheck validationCheck() {
        return new ValidationCheckImpl();
    }

    public Sorter sorter() {
        return new BasicSorter();
    }

    public Calculate calculation() {
        return new CalculateImpl(sorter());
    }

    public CalculationRepository calculationRepository() {
        return new ListRepository();
    }

    public CommandFilter commandFilter() {
        return new CommandFilterImpl();
    }

    public CalculationServiceImpl calculationService() {
        return new CalculationServiceImpl(
                commandFilter(),
                calculation(),
                calculationRepository(),
                validationCheck()
        );
    }
}
