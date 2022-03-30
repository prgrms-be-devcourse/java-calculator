package com.programmers.service;

import com.programmers.entity.CaseData;
import com.programmers.repository.CaseRepository;

import java.util.Scanner;

public class MainService {

    private CalculationService calculationService = new CalculationService();
    private Input input = new Input();
    private CaseRepository caseRepository;

    public MainService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public void playCalculate() {

        boolean isWorking = true;
        Long id = 0L;

        while (isWorking) {
            id++;

            System.out.println("1.조회");
            System.out.println("2.계산");
            System.out.println();
            System.out.print("선택 : ");


            int number = input.getOptionNumber();
            System.out.println();

            if (number == 1) {
                // 조회 로직
                caseRepository.allStoreValue();
            } else {
                // 공식 입력 받는다.(숫자 혹은 연산자)
                String inputStr = input.getString();

                // 계산 후 저장 로직
                Double result = calculationService.calculate(inputStr);
                System.out.println(result);

                // Data 저장
                CaseData caseData = new CaseData(id, inputStr, result);
                caseRepository.save(caseData);
            }
        }
    }
}
