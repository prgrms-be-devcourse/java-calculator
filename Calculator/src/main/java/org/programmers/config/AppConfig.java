package org.programmers.config;

import org.programmers.repository.CalculatorRepository;
import org.programmers.repository.Repository;
import org.programmers.service.CalculateService;
import org.programmers.service.IO.Console;

/**
 * CalculatorService와 CalculatorRepository간의 직접 결합을 끊어주기 위해
 * AppConfig 파일을 생성해서 주입 기능을 할당했습니다.
 */
public class AppConfig {

    public Console console(){

        return new Console();
    }

    public CalculateService calculateService(Repository repository){

        return new CalculateService(repository);
    }

    public CalculatorRepository calculatorRepository(){

        return new CalculatorRepository();
    }
}
