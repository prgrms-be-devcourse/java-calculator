package Calculator;

import Calculate.*;
import IO.*;
import Validator.*;
import Record.*;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class Calculator{

    private final Input input;
    private final Output output;
    private final Validator validator;
    private final Calculate calculate;
    private final RecordRepository recordRepository;

    public boolean calculatorProcess(Menu menu) {
        switch (menu) {
            case RECORD:
                recordProcess();
                break;
            case CALC:
                calcProcess();
                break;
            case ERROR:
                output.errorPrint(ErrorCode.INVALID_MENU_NUMBER);
                break;
            case EXIT:
                return false;
        }
        return true;
    }

    private void calcProcess() {
        String expression = input.input("수식을 입력해주세요").replaceAll(" ","");
        if (!check(expression)) {
            return;
        }
        long calcResult = calc(expression);
        output.output(String.valueOf(calcResult));
        recordRepository.save(new Record(expression + " = " + calcResult));
    }

    private void recordProcess() {
        Map<Long, Record> recordMap = recordRepository.findAll();
        output.allCalcRecord(recordMap);
    }

    private boolean check(String expression) {
        boolean isValidate = checkValidate(expression);
        boolean isNotDivZero = !checkDivZero(expression);
        return isValidate && isNotDivZero;
    }

    private boolean checkValidate(String expression) {
        boolean isValidate = validator.validate(expression);
        if (!isValidate) {
            output.errorPrint(ErrorCode.INVALID_EXPRESS);
            return false;
        }
        return true;
    }

    private boolean checkDivZero(String expression) {
        boolean isDivZero = validator.isDivZero(expression);
        if (isDivZero) {
            output.errorPrint(ErrorCode.INVALID_DIVIDE_ZERO);
            return true;
        }
        return false;
    }

    private long calc(String expression) {
        long calcResult = calculate.calc(expression);
        return calcResult;
    }


}
