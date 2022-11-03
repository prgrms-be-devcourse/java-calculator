package calculator.calculator.formula;

import calculator.util.regex.RegexUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static calculator.calculator.formula.ParseUnit.NO_SPACE;
import static calculator.calculator.formula.ParseUnit.SPACE;
import static calculator.calculator.operator.Operators.isOperator;
import static calculator.exception.FormulaException.FORMULA_BASIC_NULL_EXCEPTION;
import static calculator.exception.FormulaException.FORMULA_BASIC_PARSER_EXCEPTION;

public class FormulaBasicParser implements FormulaParser {

    private Formula formula;

    public FormulaBasicParser() {
    }

    @Override
    public Formula parseFrom(final String formula) {
        return generateFormula(parseNoSpace(formula));
    }

    private Formula generateFormula(final String formula) {
        initFormulaParser();

        AtomicInteger beforeIdx = new AtomicInteger(0);
        IntStream.range(0, formula.length())
                .forEach(idx -> {
                    checkFormulaRegex(formula, idx);
                    handleFormula(formula, beforeIdx, idx);
                });
        handleLastFormula(formula, beforeIdx);

        return this.formula;
    }

    private static void checkFormulaRegex(String formula, int idx) {
        if (RegexUtil.checkWrong(RegexUtil.REGEX_FORMULA_WORD, getCurrWord(formula, idx))) {
            throw new IllegalArgumentException(FORMULA_BASIC_PARSER_EXCEPTION.getMessage());
        }
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
        if (estimatedWord.isBlank()) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.getMessage());
        }

        return estimatedWord;
    }

    private void handlerOperatorInFormula(String formula, int idx) {
        String operator = getCurrWord(formula, idx);
        if (operator.isBlank()) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.getMessage());
        }

        this.formula.add(operator);
    }

    private void handleOperandInFormula(String formula, AtomicInteger beforeIdx, int idx) {
        String operand = getCurrOperand(formula, beforeIdx.getAndSet(idx + 1), idx);
        if (operand.isBlank()) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.getMessage());
        }

        this.formula.add(operand);
    }

    private void handleLastFormula(String formula, AtomicInteger beforeIdx) {
        String lastOperand = getLastOperand(formula, beforeIdx);
        if (lastOperand.isBlank()) {
            throw new NullPointerException(FORMULA_BASIC_NULL_EXCEPTION.getMessage());
        }

        this.formula.add(lastOperand);
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
        this.formula = new Formula(new ArrayList<>());
    }

    private static String parseNoSpace(final String formula) {
        return Arrays.stream(formula.split(NO_SPACE.getUnit()))
                .filter(word -> !word.equals(SPACE.getUnit()))
                .collect(Collectors.joining());
    }
}
