package service;

import domain.CalculationDto;
import repository.CalculationRepository;

import java.util.List;

public class CalculationServiceImpl implements CalculationService {

    private final CommandFilter filter;
    private final Calculation calculation;
    private final CalculationRepository calculationRepository;
    private final ValidationCheck validationCheck;

    public CalculationServiceImpl(CommandFilter filter,
                                  Calculation calculation,
                                  CalculationRepository calculationRepository,
                                  ValidationCheck validationCheck) {
        this.filter = filter;
        this.calculation = calculation;
        this.calculationRepository = calculationRepository;
        this.validationCheck = validationCheck;
    }

    @Override
    public void calculate(String command) {
        if (!validationCheck.validate(command))
            throw new RuntimeException("strange command");
        String filteredCmd = filter.filter(command);
        int result = calculation.calc(filteredCmd);
        CalculationDto calculationDto = new CalculationDto(filteredCmd, result);
        calculationRepository.save(calculationDto);
    }

    @Override
    public List<String> findAll() {
        return calculationRepository.findAll();
    }

}
