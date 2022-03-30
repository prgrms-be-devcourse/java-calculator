package com.programmers.java;

import com.programmers.java.tokenizer.Tokenizer;
import com.programmers.java.tokenizer.TokenizerImpl;
import com.programmers.java.io.Console;
import com.programmers.java.validator.Validator;
import com.programmers.java.validator.ValidatorImpl;
import com.programmers.java.repository.MemoryRepository;
import com.programmers.java.repository.Repository;
import com.programmers.java.service.CalculateService;
import com.programmers.java.service.CalculateServiceImpl;
import com.programmers.java.service.HistoryService;
import com.programmers.java.service.HistoryServiceImpl;

public class AppConfig {

    public Calculator calculator() {
        return new Calculator(console(), console(), calculateService(), findService(), validator());
    }

    public Console console() {
        return new Console();
    }

    public CalculateService calculateService() {
        return new CalculateServiceImpl(tokenizer());
    }

    public HistoryService findService() {
        return new HistoryServiceImpl(repository());
    }

    public Repository repository() {
        return new MemoryRepository();
    }

    private Validator validator() {
        return new ValidatorImpl(tokenizer());
    }

    private Tokenizer tokenizer() {
        return new TokenizerImpl();
    }

}
