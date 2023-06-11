package calculator.service;

import calculator.domain.model.SymbolPriority;
import calculator.error.exception.DivisionByZeroException;
import calculator.error.exception.WrongInputFormulaException;
import calculator.error.model.ResponseErrorFormat;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class CalculatorManager {
    private final Deque<SymbolPriority> symbolDeque = new ArrayDeque<>();
    private final Deque<Integer> numberDeque = new ArrayDeque<>();

    /**
     * 연산식의 공백을 제거하는 메소드
     *
     * @param formula : 공백을 제거할 연산식
     * @return 공백이 제거된 연산식
     */
    public String removeSpaces(String formula) {
        return formula.trim()
                .replaceAll(" ", "");
    }

    /**
     * 연산식이 사칙연산과 숫자로만 이루어져 있는 지 판단하는 유효성 검증 메소드
     *
     * @param formula : 검증할 연산식
     */
    public void isCorrectFormula(String formula) {
        if (!formula.matches("^[0-9]+([-+*/][0-9]+)*$")) {
            throw new WrongInputFormulaException(ResponseErrorFormat.FAIL_WRONG_INPUT_FORMULA);
        }
    }

    /**
     * 실제 연산이 진행되는 메소트
     *
     * @param formulaTokens : 연산을 진행할 토큰
     */
    public String calculate(StringTokenizer formulaTokens) {
        while (formulaTokens.hasMoreTokens()) {
            handleSymbolOrNumberValidation(formulaTokens.nextToken());
        }

        while (!symbolDeque.isEmpty()){
            performCalculation();
        }

        return String.valueOf(numberDeque.pop());
    }

    /**
     * 해당 토큰값이 연산자인지 숫자인지 판단 후 그에 맞는 로직을 진행하는 메소드
     *
     * @param token : 검사할 토큰
     */
    private void handleSymbolOrNumberValidation(String token) {
        if (token.matches("^[0-9]+$")) {
            numberDeque.push(Integer.parseInt(token));
            return;
        }
        if (token.matches("[-+*/]")) {
            SymbolPriority nextSymbol = SymbolPriority.from(token);
            while (!symbolDeque.isEmpty() && symbolDeque.peek().getPriority() >= nextSymbol.getPriority()){
                performCalculation();
            }
            symbolDeque.push(nextSymbol);
        }
    }

    private void performCalculation(){
        isDivisionByZero(symbolDeque.peek().getSymbol(), numberDeque.peek());
        int secondNumber = numberDeque.pop();
        int firstNumber = numberDeque.pop();
        int result = symbolDeque.pop()
                .getFormula()
                .apply(firstNumber, secondNumber);

        numberDeque.push(result);
    }

    /**
     * 0인지 검증하는 메소드
     *
     * @param symbol       : 연산자
     * @param secondNumber : 검증할 2번째 메소드
     * @return secondNumber
     */
    private void isDivisionByZero(String symbol,
                                  int secondNumber) {
        if (symbol.equals("/") && secondNumber == 0) {
            throw new DivisionByZeroException(ResponseErrorFormat.FAIL_DIVISION_BY_ZERO);
        }
    }
}
