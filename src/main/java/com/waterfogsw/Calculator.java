package com.waterfogsw;

import com.waterfogsw.domain.Calculation;
import com.waterfogsw.exception.DoubleOverflow;
import com.waterfogsw.io.Input;
import com.waterfogsw.io.MenuType;
import com.waterfogsw.io.Output;
import com.waterfogsw.service.CalculationService;
import com.waterfogsw.service.HistoryService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Calculator implements Runnable {

    private final Input input;
    private final Output output;
    private final HistoryService historyService;
    private final CalculationService calculationService;

    @Override
    public void run() {
        while (true) {
            System.out.println("1. 조회");
            System.out.println("2. 계산\n");
            try {
                int menu = input.inputMenu("선택 : ");
                switch (menu) {
                    case MenuType.LOOKUP:
                        // 1. 조회 메뉴 입력
                        List<Calculation> histories = historyService.findAll();
                        output.printHistories(histories);
                        break;
                    case MenuType.CALCULATE:
                        // 2. 계산 메뉴 입력
                        String expr = input.inputFormula("계산식 : ");
                        String result = calculationService.getResult(expr);

                        output.printResult(expr, result);
                        historyService.save(expr, result);
                        break;
                    default:
                        throw new Exception();
                }
            } catch (ArithmeticException e) {
                output.divZeroError();
            } catch (DoubleOverflow e) {
                output.dataOverflowError();
            } catch (Exception e) {
                output.inputError();
            }
        }
    }
}
