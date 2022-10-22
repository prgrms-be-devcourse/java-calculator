package calculator.calculator.formula;

import calculator.util.regex.RegexUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static calculator.calculator.formula.ParseUnit.NO_SPACE;
import static calculator.calculator.formula.ParseUnit.SPACE;
import static calculator.calculator.operator.Operators.isOperator;
import static calculator.exception.FormulaException.FORMULA_BASIC_PARSER_EXCEPTION;

public class FormulaBasicParser implements FormulaParser {

    @Override
    public List<String> parseFrom(final String formula) {
        return generateFormula(parseNoSpace(formula));
    }

    private List<String> generateFormula(final String formula) {
        List<String> formulas = new ArrayList<>();
        AtomicInteger beforeIdx = new AtomicInteger(0);

        IntStream.range(0, formula.length())
                .forEach(idx -> {
                    String word = formula.substring(idx, idx + 1);
                    if (RegexUtil.checkWrong(RegexUtil.REGEX_FORMULA_WORD, word)) {
                        throw new IllegalArgumentException(FORMULA_BASIC_PARSER_EXCEPTION.message);
                    }

                    boolean checkOperator = isOperator(word);
                    if (checkOperator) {
                        formulas.add(
                                formula.substring(beforeIdx.getAndSet(idx), idx + 1));
                    }
                    if (!checkOperator) {
                        formulas.add(
                                formula.substring(idx, idx + 1));
                        beforeIdx.set(idx + 1);
                    }
                });

        return formulas;
    }

    private static String parseNoSpace(final String formula) {
        return Arrays.stream(formula.split(NO_SPACE.unit))
                .filter(word -> !word.equals(SPACE.unit))
                .collect(Collectors.joining());
    }
}
