package calulator.view;

import java.util.List;

public class OutputView {

    public static void printCalculateResult(String result) {
        System.out.println(result);
    }

    public static void printCalculateResults(List<String> results) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result + "\n");
        }
        System.out.println(stringBuilder);
    }
}
