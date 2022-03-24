package service;

import static java.lang.Character.isWhitespace;
import static utils.ValidationUtil.*;
import static utils.ValidationUtil.isNumberWithWhite;

/**
 * 올바른 포맷: [숫자 -> 연산자 -> 숫자]
 */
public class ValidationCheckImpl implements ValidationCheck {

    private int getStartIndex(String command, int len) {
        int i = 0;
        // 공백제거
        while (i < len && isWhitespace(command.charAt(i))) {
            i++;
        }
        // -부호로 시작은 가능
        if (i < len && command.charAt(i) == '-')
            i++;
        return i;
    }

    public boolean validate(String command) {
        int len = command.length();
        boolean existOp = false;
        int i = getStartIndex(command, len);
        // 실수의 경우 . 는 1번만 나오도록
        boolean dotExist = false;

        while (i < len) {
            // 반복의 시작은 반드시 숫자. (최초 입력 및 연산자 중복되는 경우 체크)
            if (!isNumberWithWhite(command.charAt(i)))
                return false;
            while (i < len && isNumberWithWhite(command.charAt(i))) {
                i++;
            }
            if (i < len && command.charAt(i) == '.') {
                if (dotExist)
                    return false;
                i++;
                dotExist = true;
                continue;
            }
            dotExist = false;
            // 연산자가 존재하면서, 숫자로 종료된 경우가 정상 Case
            if (existOp && i == len)
                return true;
            // 다음은 연산자
            if (i < len && !isOperator(command.charAt(i)))
                return false;
            // 한번이라도 타면 연산자는 존재함.
            existOp = true;
            i++;
        }
        return false;
    }
}
