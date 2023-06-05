package org.service;

import org.domain.model.Calculator;
import org.domain.model.SymbolPriority;
import org.domain.repository.CalculationRepository;
import org.error.ResponseErrorFormat;

import java.util.*;

public class CalculationService {

    private final CalculationRepository calculationRepository;

    private Stack<SymbolPriority> symbolStack = new Stack<>();

    private Stack<Integer> numberStack = new Stack<>();

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    /**
     * 모든 계산 기록 조회하는 메소드
     * 형식 : "연산식 = 연산결과"
     */
    public void getCalculationsAll() {

        calculationRepository
                .findAll()
                .forEach(
                        calculator -> System.out.println(calculator.getOperation() + "=" + calculator.getAnswer())
                );
    }

    /**
     * 계산기 실행 메소드
     *
     * @param operation : 계산을 진행할 연산식
     */
    public void calculate(String operation) {

        operation = removeSpaces(operation);

        isCorrectOperation(operation);

        final StringTokenizer stringTokenizer = new StringTokenizer(operation, "+-/*", true);

        processOperatorsAndNumbers(stringTokenizer);

        final Calculator calculator = new Calculator(operation, numberStack.pop() + "");

        System.out.println(calculator.getOperation() + "=" + calculator.getAnswer() + "\n");

        calculationRepository.save(calculator);
    }

    /**
     * 연산식의 공백을 제거하는 메소드
     *
     * @param operation : 공백을 제거할 연산식
     * @return 공백이 제거된 연산식
     */
    private String removeSpaces(String operation) {

        return operation.trim().replaceAll(" ", "");
    }

    /**
     * 연산식이 사칙연산과 숫자로만 이루어져 있는 지 판단하는 유효성 검증 메소드
     *
     * @param operation : 검증할 연산식
     */
    private void isCorrectOperation(String operation) {

        if (!operation.matches("^[0-9]+([-+*/][0-9]+)*$")) {
            throw new IllegalArgumentException(ResponseErrorFormat.ERROR_BAD_OPERATION.getMessage());
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
                            .getOperation()
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
                    .getOperation()
                    .apply(firstNumber, secondNumber);

            numberStack.push(result);
        }
    }
}
