package calculator.view.output;

import calculator.calculator.operator.Operators;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static calculator.view.output.TextUnit.*;
import static java.util.stream.IntStream.range;

public class MenuHistoryOutput implements BaseOutput {

    public void printHistories(Collection<?> histories) {
        HashMap<String, String> newHistories = new HashMap<>();

        histories.stream()
                .map(history -> (Map.Entry<String, String>) history)
                .forEach(parsedHistory -> newHistories.put(
                        parsedHistory.getKey(),
                        parsedHistory.getValue()));

        print(createHistories(newHistories) + ENTER.unit);
    }

    private String createHistories(HashMap<String, String> histories) {
        StringBuilder textBuilder = new StringBuilder();

        histories.keySet()
                .forEach((formula) -> range(0, formula.length())
                        .forEach(idx -> {
                            handleOperator(textBuilder, formula.substring(idx, idx + 1));
                            handleOperand(textBuilder, formula.substring(idx, idx + 1));
                            handleAnswer(histories, textBuilder, formula, idx);
                        }));

        return textBuilder.toString();
    }

    private static void handleAnswer(HashMap<String, String> histories,
                                     StringBuilder textBuilder,
                                     String formula,
                                     int idx) {

        if (idx == formula.length() - 1) {
            textBuilder.append(SPACE.unit)
                    .append(EQUAL.unit)
                    .append(SPACE.unit)
                    .append(histories.get(formula))
                    .append(ENTER.unit);
        }
    }

    private static void handleOperand(StringBuilder textBuilder, String word) {
        if (Character.isDigit(word.charAt(0))) {
            textBuilder.append(word);
        }
    }

    private static void handleOperator(StringBuilder textBuilder, String word) {
        if (Operators.isOperator(word)) {
            textBuilder.append(SPACE.unit)
                    .append(word)
                    .append(SPACE.unit);
        }
    }
}
