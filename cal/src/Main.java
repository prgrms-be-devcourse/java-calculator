import model.Calculator;
import model.History;
import model.Operator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> log = new ArrayList<>();
    public static void main(String[] args) {

        Console console = new Console();
        Calculator calculator = new Calculator();
        Operator operator = new Operator();
        History history = new History();
        new Index(console,history,calculator,operator).run();
    }


}
