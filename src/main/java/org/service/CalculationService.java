package org.service;

import org.domain.repository.CalculationRepository;

public class CalculationService {

    private final CalculationRepository calculationRepository;

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
}
