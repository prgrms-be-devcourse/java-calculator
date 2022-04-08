package Calculator;

import Calculate.*;
import IO.*;
import Result.ErrorCode;
import Result.Result;
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
        Result result = null;
        switch (menu) {
            case RECORD:
                result = recordProcess();
                break;
            case CALC:
                result = calcProcess();
                break;
            case EXIT:
                return false;
        }
        if (result.hasError()) {
            result.printError();
        }
        return true;
    }

    private Result calcProcess() {
        String expression = input.input("수식을 입력해주세요").replaceAll(" ","");
        if (!check(expression)) {
            return new Result(ErrorCode.INVALID_EXPRESS);
        }
        long calcResult = calc(expression);
        output.output(String.valueOf(calcResult));
        recordRepository.save(new Record(expression + " = " + calcResult));
        return new Result();
    }

    private Result recordProcess() {
        Map<Long, Record> recordMap = recordRepository.findAll();
        output.allCalcRecord(recordMap);
        return new Result();
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
