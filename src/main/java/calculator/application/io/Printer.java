package calculator.application.io;

import java.util.List;

public class Printer {

    public void printLiterals(List<String> literals) {
        literals.forEach(this::printLine);
    }

    public void printLine(Object object) {
        System.out.println(object);
    }

    public void print(Object object) {
        System.out.print(object);
    }
}
