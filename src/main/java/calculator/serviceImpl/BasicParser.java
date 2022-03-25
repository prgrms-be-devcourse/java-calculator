package calculator.serviceImpl;

import calculator.service.Parser;

import java.util.Map;

import static calculator.engine.utils.Util.*;
import static java.lang.Character.isWhitespace;

public class BasicParser implements Parser {

    @Override
    public String parse(String command) {
        int len = command.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 공백제거
        while (i < len && isWhitespace(command.charAt(i))) {
            i++;
        }
        // -부호로 시작은 가능
        if (i < len && command.charAt(i) == '-') {
            sb.append('-');
            i++;
        }
        return parsing(command, len, sb, i);
    }

    private String parsing(String command, int len, StringBuilder sb, int i) {
        boolean existOp = false;
        boolean dotExist = false;
        Map<Character, Integer> operatorMap = getOperatorMap();

        while (i < len) {
            if (!isNumberWithWhite(command.charAt(i)))
                return null;
            while (i < len && isNumberWithWhite(command.charAt(i))) {
                if (isNumber(command.charAt(i)))
                    sb.append(command.charAt(i));
                i++;
            }
            if (i < len && command.charAt(i) == '.') {
                if (dotExist)
                    return null;
                sb.append(command.charAt(i++));
                dotExist = true;
                continue;
            }
            dotExist = false;
            if (existOp && i == len)
                return sb.toString();
            if (i < len) {
                if (!isOperator(command.charAt(i)))
                    return null;
                sb.append(' ').append(command.charAt(i)).append(' ');
            }
            existOp = true;
            i++;
        }
        return null;
    }
}
