package src;


import src.io.ConsoleReader;
import src.io.ConsoleWriter;
import src.io.Input;
import src.io.Output;
import src.log.LogRepository;
import src.log.LogService;
import src.log.MemoryLogRepository;


/**
 * 의존성 주입 & calculatorApp 실행
 */
public class Main{
    public static void main(String[] args){

        LogRepository logRepository = new MemoryLogRepository();
        LogService logger = new LogService(logRepository);
        Input cr = new ConsoleReader(System.in);
        Output cw = new ConsoleWriter();
        CalculatorApp calculatorApp = new CalculatorApp(logger, cr, cw);

        calculatorApp.run();
    }
}
