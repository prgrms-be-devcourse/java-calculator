package calculator.engine;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.model.HistoryDatabase;
import calculator.engine.model.Menu;
import calculator.engine.model.PostfixCalculator;
import calculator.engine.model.PostfixConverter;

import java.util.List;
import java.util.Optional;

public class Calculator implements Runnable {
    private final Input input;
    private final Output output;
    private final HistoryDatabase database;

    public Calculator(Input input, Output output, HistoryDatabase database) {
        this.input = input;
        this.output = output;
        this.database = database;
    }

    @Override
    public void run() {

        while (true) {
            // 메뉴 선택 입력
            Optional<Menu> selectedMenu = input.inputMenu();

            // '1. 조회'나 '2. 계산'인 경우
            selectedMenu.ifPresentOrElse(menu -> {
                        runCalculator(menu);        // 계산기 실행
                    }, () -> {
                        System.exit(0);        // 종료
                    }
            );
        }
    }

    private void runCalculator(Menu selectedMenu) {
        if (selectedMenu.equals(Menu.INQUIRY)) {
            output.calcHistory(database.getHistories());
        } else {
            // 입력받음
            String arith = input.inputArith();

            // 계산
            Double result = calculate(arith);

            // 계산 결과 저장
            database.addHistory(arith, result);

            // 계산 결과 출력
            output.calcResult(result);
        }
    }

    private Double calculate(String arith) {
        String[] infix = Input.parse(arith);
        var postfixConverter = new PostfixConverter();
        List<String> postfix = postfixConverter.convertToPostfix(infix);
        return PostfixCalculator.getResult(postfix);
    }
}
