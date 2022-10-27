package calculator.view.output;

import static calculator.view.output.TextUnit.ENTER;

public class MenuCalculatorOutput implements BaseOutput {

    public void printAnswer(String answer) {
        print(answer + ENTER.getUnit());
    }

    public void printAfter() {
        print(ENTER.getUnit());
    }
}
