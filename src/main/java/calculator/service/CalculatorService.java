package calculator.service;

import calculator.domain.repository.CalculatorRepository;
import calculator.domain.model.HistoryModel;
import calculator.domain.model.SymbolPriority;
import calculator.error.exception.WrongInputFormulaException;
import calculator.error.model.ResponseErrorFormat;

import java.util.*;

public class CalculatorService {

    private final CalculatorRepository calculatorRepository;
    private final Stack<SymbolPriority> symbolStack = new Stack<>();
    private final Stack<Integer> numberStack = new Stack<>();

    public CalculatorService(CalculatorRepository calculatorRepository) {

        this.calculatorRepository = calculatorRepository;
    }

    /**
     * 모든 계산 기록 조회하는 메소드
     * 형식 : "연산식 = 연산결과"
     */
    public void getHistoryAll() {
        calculatorRepository
                .findAll()
                .forEach(
                        history -> System.out.println(history.getFormula() + "=" + history.getAnswer())
                );
    }

    /**
     * 계산기 실행 메소드
     *
     * @param formula : 계산을 진행할 연산식
     */
    public void calculate(String formula) {
        isCorrectFormula(removeSpaces(formula));

        final StringTokenizer formulaTokens = new StringTokenizer(formula, "+-/*", true);
        processOperatorsAndNumbers(formulaTokens);

        final HistoryModel history = new HistoryModel(formula, numberStack.pop() + "");
        System.out.println(history.getFormula() + "=" + history.getAnswer() + "\n");

        calculatorRepository.save(history);
    }

    /**
     * 연산식의 공백을 제거하는 메소드
     *
     * @param formula : 공백을 제거할 연산식
     * @return 공백이 제거된 연산식
     */
    private String removeSpaces(String formula) {

        return formula.trim().replaceAll(" ", "");
    }

    /**
     * 연산식이 사칙연산과 숫자로만 이루어져 있는 지 판단하는 유효성 검증 메소드
     *
     * @param formula : 검증할 연산식
     */
    private void isCorrectFormula(String formula) {
        if (!formula.matches("^[0-9]+([-+*/][0-9]+)*$")) {
            throw new WrongInputFormulaException(ResponseErrorFormat.FAIL_WRONG_INPUT_FORMULA);
        }
    }

    /**
     * 실제 연산이 진행되는 메소트
     *
     * @param stringTokenizer : 연산을 진행할 토큰
     */
    private void processOperatorsAndNumbers(StringTokenizer stringTokenizer) {
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (token.matches("[-+*/]")) {
                SymbolPriority nextSymbol = SymbolPriority.from(token);

                while (!symbolStack.isEmpty() &&
                        symbolStack.peek().getPriority() >= nextSymbol.getPriority()) {
                    int secondNumber = numberStack.pop();
                    int firstNumber = numberStack.pop();
                    int result = symbolStack.pop()
                            .getFormula()
                            .apply(firstNumber, secondNumber);

                    numberStack.push(result);
                }

                symbolStack.push(nextSymbol);
            } else {
                numberStack.push(Integer.parseInt(token));
            }
        }

        while (!symbolStack.isEmpty()) {
            int secondNumber = numberStack.pop();
            int firstNumber = numberStack.pop();
            int result = symbolStack.pop()
                    .getFormula()
                    .apply(firstNumber, secondNumber);

            numberStack.push(result);
        }
    }
}
