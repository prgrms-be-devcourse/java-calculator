package com.programmers;

import com.programmers.entity.CaseData;
import com.programmers.repository.CaseRepository;
import com.programmers.repository.MemoryRepository;
import com.programmers.service.CalculationService;
import com.programmers.service.ValidationService;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        ValidationService validationCase = new ValidationService();
        CalculationService calculationService = new CalculationService();
        CaseRepository caseRepository = new MemoryRepository();

        Scanner sc = new Scanner(System.in);
        boolean isWorking = true;
        Long id = 0L;
        while(isWorking){
            id++;
            System.out.println("1.조회");
            System.out.println("2.계산");
            System.out.println();
            System.out.print("선택 : ");
            int number;
            try{
                number = sc.nextInt();
                sc.nextLine();
                if(!validationCase.validationNumber(number)) break;
            }catch (Exception e){
                break;
            }
            System.out.println();


            if(number == 1){
                // 조회 로직
                caseRepository.allStoreValue();
            }
            else{
                // 공식 입력 받는다.
                String input = sc.nextLine();
                if(!validationCase.validationInput(input)) break;
                // 계산 후 저장 로직
                Double result = calculationService.calculate(input);
                // 0 으로 나눈 경우 예외처리
                if(result==null){
                    System.out.println("0으로 나누었습니다 - error");
                    break;
                }
                System.out.println(result);

                // Data 저장
                CaseData caseData = new CaseData(id, input, result);
                caseRepository.save(caseData);
            }
        }
    }
}
