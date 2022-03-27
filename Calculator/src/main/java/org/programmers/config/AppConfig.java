package org.programmers.config;

import org.programmers.repository.CalculatorRepository;
import org.programmers.service.CalculateService;
import org.programmers.service.IO.Console;

public class AppConfig {

    public Console console(){
        return new Console();
    }

    public CalculateService calculateService(){
        return new CalculateService(new CalculatorRepository());
    }
}
