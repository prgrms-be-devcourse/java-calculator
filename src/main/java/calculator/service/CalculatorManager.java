package calculator.service;

import calculator.domain.model.SymbolPriority;
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

        return formula.trim().replaceAll(" ", "");
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
            isSymbolAndNumber(formulaTokens.nextToken());
        }

        return isCalculation() + "";
    }

    /**
     * 해당 토큰값이 연산자인지 숫자인지 판단 후 그에 맞는 로직을 진행하는 메소드
     *
     * @param token : 검사할 토큰
     */
    public void isSymbolAndNumber(String token) {
        if (token.matches("[-+*/]")) {
            isCalculation(SymbolPriority.from(token));
        } else {
            numberDeque.push(Integer.parseInt(token));
        }
    }

    /**
     * 현재 연산식에서 가장 우선 순위가 높은 연산자가 있다면 계산을 진행하는 메소드
     *
     * @param nextSymbol : 검사할 다음 연산자
     */
    private void isCalculation(SymbolPriority nextSymbol) {
        while (!symbolDeque.isEmpty() && symbolDeque.peek().getPriority() >= nextSymbol.getPriority()) {
            int secondNumber = numberDeque.pop();
            int firstNumber = numberDeque.pop();
            int result = symbolDeque.pop()
                    .getFormula()
                    .apply(firstNumber, secondNumber);

            numberDeque.push(result);
        }

        symbolDeque.push(nextSymbol);
    }

    /**
     * 우선순위가 가장 낮았던, 즉, 마지막에 남은 연산 진행
     */
    public int isCalculation() {
        while (!symbolDeque.isEmpty()) {
            int secondNumber = numberDeque.pop();
            int firstNumber = numberDeque.pop();
            int result = symbolDeque.pop()
                    .getFormula()
                    .apply(firstNumber, secondNumber);

            numberDeque.push(result);
        }

        return numberDeque.pop();
    }
}
