package com.wonu606.calculator;

import com.wonu606.app.App;
import com.wonu606.calculator.storage.Persistence;
import com.wonu606.calculator.storage.ResultStore;
import com.wonu606.calculator.strategy.Strategy;
import com.wonu606.io.Input;
import com.wonu606.io.Print;
import com.wonu606.calculator.util.CalculatorMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalculatorApp implements App {

    private final List<Strategy> strategies = new ArrayList<>();
    private final Persistence store = new ResultStore();
    Input input;
    Print printer;

    public CalculatorApp() {
        initStrategies();
    }

    private void initStrategies() {
        // TODO 조회와 계산 기능을 생성하여 추가해야 함
    }

    public void execute(Input input, Print printer) throws IOException {
        this.input = input;
        this.printer = printer;

        while (true) {
            int selection = Integer.parseInt(input.getInput());

            Optional<Strategy> selectedStrategy =
                    Optional.ofNullable(strategies.get(selection - 1));
            selectedStrategy.ifPresentOrElse(
                    strategy -> strategy.execute(input, printer, store),
                    () -> {
                        throw new IllegalArgumentException(CalculatorMessage.INVALID_INPUT.message);
                    });
        }
    }
}
