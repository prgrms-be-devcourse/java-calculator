package calulator.view.console;

import calulator.view.OutputView;

import java.util.List;

public class ConsoleOutput implements OutputView {

    public void printCalculateResult(String result) {
        System.out.println(result);
    }

    public void printCalculateResults(List<String> results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + "\n");
        }
        System.out.println(stringBuilder);
    }
}
