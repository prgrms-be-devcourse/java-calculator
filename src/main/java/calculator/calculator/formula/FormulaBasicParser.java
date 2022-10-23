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
import static calculator.exception.FormulaException.FORMULA_BASIC_NULL_EXCEPTION;
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
                    if (RegexUtil.checkWrong(RegexUtil.REGEX_FORMULA_WORD, getCurrWord(formula, idx))) {
                        throw new IllegalArgumentException(FORMULA_BASIC_PARSER_EXCEPTION.message);
                    }
                    handleFormula(formula, beforeIdx, idx);
                });
        handleLastFormula(formula, beforeIdx);

        return formulas;
    }

    private void handleFormula(String formula, AtomicInteger beforeIdx, int idx) {
        String estimatedWord = estimateWordInFormula(formula, idx);

        if (isOperator(estimatedWord)) {
            handleOperandInFormula(formula, beforeIdx, idx);
            handlerOperatorInFormula(formula, idx);
        }
    }

    private static String estimateWordInFormula(String formula, int idx) {
        String estimatedWord = getCurrWord(formula, idx);
        if (estimatedWord.length() == 0) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.message);
        }

        return estimatedWord;
    }

    private void handlerOperatorInFormula(String formula, int idx) {
        String operator = getCurrWord(formula, idx);
        if (operator.length() == 0) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.message);
        }

        formulas.add(operator);
    }

    private void handleOperandInFormula(String formula, AtomicInteger beforeIdx, int idx) {
        String operand = getCurrOperand(formula, beforeIdx.getAndSet(idx + 1), idx);
        if (operand.length() == 0) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.message);
        }

        formulas.add(operand);
    }

    private void handleLastFormula(String formula, AtomicInteger beforeIdx) {
        String lastOperand = getLastOperand(formula, beforeIdx);
        if (lastOperand.length() == 0) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.message);
        }

        formulas.add(lastOperand);
    }

    private static String getCurrWord(String formula, int idx) {
        return formula.substring(idx, idx + 1);
    }

    private static String getCurrOperand(String formula, int beforeIdx, int idx) {
        return formula.substring(beforeIdx, idx);
    }

    private static String getLastOperand(String formula, AtomicInteger beforeIdx) {
        return formula.substring(beforeIdx.get());
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
