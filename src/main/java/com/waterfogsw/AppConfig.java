package com.waterfogsw;

import com.waterfogsw.converter.Converter;
import com.waterfogsw.converter.PostfixConverter;
import com.waterfogsw.io.Console;
import com.waterfogsw.parser.Parser;
import com.waterfogsw.parser.StringParser;
import com.waterfogsw.repository.CalculationRepository;
import com.waterfogsw.repository.MemoryCalculationRepository;
import com.waterfogsw.service.CalculationService;
import com.waterfogsw.service.CalculationServiceImpl;
import com.waterfogsw.service.HistoryService;
import com.waterfogsw.service.HistoryServiceImpl;

public class AppConfig {
    public Calculator calculator() {
        return new Calculator(console(), console(), historyService(), calculationService());
    }

    public Console console() {
        return new Console();
    }

    public Parser parser() {
        return new StringParser();
    }

    public Converter converter() {
        return new PostfixConverter();
    }

    public CalculationRepository calculationRepository() {
        return new MemoryCalculationRepository();
    }

    public CalculationService calculationService() {
        return new CalculationServiceImpl(parser(), converter());
    }

    public HistoryService historyService() {
        return new HistoryServiceImpl(calculationRepository());
    }

}
