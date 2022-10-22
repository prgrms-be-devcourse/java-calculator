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

    private final List<String> formulas;

    public FormulaBasicParser() {
        this.formulas = new ArrayList<>();
    }

    @Override
    public List<String> parseFrom(final String formula) {
        return generateFormula(parseNoSpace(formula));
    }

    private List<String> generateFormula(final String formula) {
        initFormulaParser();

        AtomicInteger beforeIdx = new AtomicInteger(0);
        IntStream.range(0, formula.length())
                .forEach(idx -> {
                    if (RegexUtil.checkWrong(RegexUtil.REGEX_FORMULA_WORD, formula.substring(idx, idx + 1))) {
                        throw new IllegalArgumentException(FORMULA_BASIC_PARSER_EXCEPTION.message);
                    }
                    handleOperator(formula, beforeIdx, idx);
                    handlerOperand(formula, beforeIdx, idx);
                });

        return formulas;
    }

    private void handlerOperand(String formula, AtomicInteger beforeIdx, int idx) {
        String word = formula.substring(idx, idx + 1);
        if (isOperator(word)) {
            formulas.add(word);
            beforeIdx.set(idx + 1);
        }
    }

    private void handleOperator(String formula, AtomicInteger beforeIdx, int idx) {
        String word = formula.substring(idx, idx + 1);
        if (!isOperator(word)) {
            formulas.add(
                    formula.substring(beforeIdx.getAndSet(idx), idx + 1));
        }
    }

    private void initFormulaParser() {
        formulas.clear();
    }

    private static String parseNoSpace(final String formula) {
        return Arrays.stream(formula.split(NO_SPACE.unit))
                .filter(word -> !word.equals(SPACE.unit))
                .collect(Collectors.joining());
    }
}
