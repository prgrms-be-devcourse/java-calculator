package calculator.serviceImpl;

import calculator.engine.model.CalculationDto;
import calculator.repository.CalculationRepository;
import calculator.service.Calculate;
import calculator.service.CalculateService;
import calculator.service.Parser;

import java.util.List;

public class CalculationServiceImpl implements CalculateService {

    private final CalculationRepository calculationRepository;
    private final Parser parser;
    private final Calculate calculation;

    public CalculationServiceImpl(CalculationRepository calculationRepository,
                                  Parser parser,
                                  Calculate calculation) {
        this.calculationRepository = calculationRepository;
        this.parser = parser;
        this.calculation = calculation;
    }

    @Override
    public CalculationDto calculate(String command) {
        String parsedCmd = parser.parse(command);
        if (parsedCmd == null)
            return null;
        double result = calculation.calc(parsedCmd);
        CalculationDto calculationDto = new CalculationDto(parsedCmd, result);
        calculationRepository.save(calculationDto);
        return calculationDto;
    }

    @Override
    public List<String> findAll() {
        return calculationRepository.findAll();
    }

}
