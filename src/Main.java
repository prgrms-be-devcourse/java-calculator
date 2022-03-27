package src;


import src.io.ConsoleReader;
import src.io.ConsoleWriter;
import src.io.Input;
import src.io.Output;
import src.log.LogDB;
import src.log.Logger;
import src.log.MemoryLogDB;


/**
 * 의존성 주입 & calculatorApp 실행
 */
public class Main {
    public static void main(String[] args) {

        LogDB logDB = new MemoryLogDB();
        Logger logger = new Logger(logDB);
        Input cr = new ConsoleReader(System.in);
        Output cw = new ConsoleWriter();
        CalculatorApp calculatorApp = new CalculatorApp(logger, cr, cw);

        calculatorApp.run();
    }
}
