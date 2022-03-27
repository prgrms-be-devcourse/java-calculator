package com.waterfogsw;

import com.waterfogsw.converter.Converter;
import com.waterfogsw.converter.PostfixConverter;
import com.waterfogsw.io.Console;
import com.waterfogsw.tokenizer.Tokenizer;
import com.waterfogsw.tokenizer.StringTokenizer;
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

    public Tokenizer tokenizer() {
        return new StringTokenizer();
    }

    public Converter converter() {
        return new PostfixConverter();
    }

    public CalculationRepository calculationRepository() {
        return new MemoryCalculationRepository();
    }

    public CalculationService calculationService() {
        return new CalculationServiceImpl(tokenizer(), converter());
    }

    public HistoryService historyService() {
        return new HistoryServiceImpl(calculationRepository());
    }

}
