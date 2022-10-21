package calculator.formula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static calculator.formula.ParseUnit.NO_SPACE;
import static calculator.formula.ParseUnit.SPACE;

public class FormulaBasicParser implements FormulaParser {

    public List<String> parseFrom(final String formula) {
        return generateFormula(parseNoSpace(formula));
    }

    private List<String> generateFormula(String formula) {
        List<String> formulas = new ArrayList<>();
        AtomicInteger beforeIdx = new AtomicInteger(0);

        IntStream.range(0, formula.length())
                .filter(checkLetter(formula))
                .forEach(idx -> {
                    formulas.add(
                            formula.substring(beforeIdx.getAndSet(idx), idx));
                    formulas.add(
                            String.valueOf(formula.charAt(idx)));
                });

        return formulas;
    }

    private IntPredicate checkLetter(final String formula) {
        return idx -> Character.isLetter(formula.charAt(idx));
    }

    private static String parseNoSpace(final String formula) {
        return Arrays.stream(formula.split(NO_SPACE.unit))
                .filter(word -> !word.equals(SPACE.unit))
                .collect(Collectors.joining());
    }
}
