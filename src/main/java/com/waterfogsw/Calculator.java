package com.waterfogsw;

import com.waterfogsw.domain.Calculation;
import com.waterfogsw.exception.DoubleOverflow;
import com.waterfogsw.exception.InvalidFormulaInput;
import com.waterfogsw.exception.InvalidMenuInput;
import com.waterfogsw.io.Input;
import com.waterfogsw.io.MenuType;
import com.waterfogsw.io.Output;
import com.waterfogsw.service.CalculationService;
import com.waterfogsw.service.HistoryService;
import lombok.AllArgsConstructor;

import java.io.IOException;
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
                menuHandle(menu);
            } catch (ArithmeticException e) {
                output.divZeroError();
            } catch (DoubleOverflow e) {
                output.dataOverflowError();
            } catch (Exception e) {
                output.inputError();
            }
        }
    }

    private void menuHandle(int menu) throws Exception {
        switch (menu) {
            case MenuType.LOOKUP -> {
                // 1. 조회 메뉴 입력
                List<Calculation> histories = historyService.findAll();
                output.printHistories(histories);
            }
            case MenuType.CALCULATE -> {
                // 2. 계산 메뉴 입력
                String expr = input.inputFormula("계산식 : ");
                String result = calculationService.getResult(expr);
                output.printResult(expr, result);
                historyService.save(expr, result);
            }
            default -> throw new InvalidMenuInput();
        }
    }

}
