package calculator.service;

import calculator.domain.model.HistoryModel;
import calculator.domain.repository.CalculatorRepository;

import java.util.List;
import java.util.StringTokenizer;

public class CalculatorService {

    private final CalculatorRepository calculatorRepository;
    private final CalculatorManager calculatorManager;

    public CalculatorService(CalculatorRepository calculatorRepository,
                             CalculatorManager calculatorManager) {
        this.calculatorRepository = calculatorRepository;
        this.calculatorManager = calculatorManager;
    }

    /**
     * 모든 계산 기록 조회하는 메소드
     * 형식 : "연산식 = 연산결과"
     */
    public List<HistoryModel> getHistoryAll() {

        return calculatorRepository.findAll();
    }

    /**
     * 계산기 실행 메소드
     *
     * @param formula : 계산을 진행할 연산식
     */
    public HistoryModel calculate(String formula) {
        final String removeSpacesFormula = calculatorManager.removeSpaces(formula);
        calculatorManager.isCorrectFormula(removeSpacesFormula);

        final StringTokenizer formulaTokens = new StringTokenizer(removeSpacesFormula, "+-/*", true);
        final HistoryModel history = new HistoryModel(removeSpacesFormula, calculatorManager.calculate(formulaTokens));
        calculatorRepository.save(history);

        return history;
    }
}