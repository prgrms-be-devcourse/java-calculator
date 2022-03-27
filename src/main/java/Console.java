import engine.io.Input;
import engine.io.Output;
import engine.model.Function;

import java.util.Scanner;

public class Console implements Output, Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void outputFunction(Function function) {
        function.indexForEach(System.out::println);
        System.out.println(System.lineSeparator());
    }

    @Override
    public void inputFunctionError() {
        System.out.println("올바른 기능을 선택해 주세요.");
    }

    @Override
    public String inputFunction(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }
}
