package com.waterfogsw;

import com.waterfogsw.domain.Calculation;
import com.waterfogsw.io.Input;
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
                if (menu == 1) {
                    List<Calculation> histories = historyService.findAll();
                    output.printHistories(histories);
                } else {
                    String expr = input.inputExpr("계산식 : ");
                    String result = calculationService.getResult(expr);

                    output.printResult(expr, result);
                    historyService.save(expr, result);
                }
            } catch (ArithmeticException e) {
                output.divZeroError();
                return;
            } catch (Exception e) {
                output.inputError();
                return;
            }
        }
    }
}
