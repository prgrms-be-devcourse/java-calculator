import Calculator.*;
import Calculate.*;
import IO.Console;
import Validator.*;
import Record.RecordMemoryRepository;
import Record.RecordRepository;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Validator validator = new RegularExpressionValidator();
        Calculate calculate = new StackCalculate();
        RecordRepository recordRepository = new RecordMemoryRepository();
        Calculator calculator = new Calculator(console, console, validator, calculate, recordRepository);
        while (true) {
            console.showMenu();
            String command = console.input("입력: ");
            Menu manual = Menu.getManual(command);
            if (!calculator.calculatorProcess(manual)) {
                break;
            }
        }
    }

}
