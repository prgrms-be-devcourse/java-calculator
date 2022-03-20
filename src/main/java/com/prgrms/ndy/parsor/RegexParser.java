package com.prgrms.ndy.parsor;

import com.prgrms.ndy.operation.Opcode;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 정규식 기반 파서
 */
public class RegexParser extends Parser {

    private static final String REGEX_VALIDATION = "^((-?\\d*\\.?\\d+)[\\+\\-\\*\\/])+(-?\\d*\\.?\\d+)$";
    private static final String REGEX_SPLIT = "([P\\+\\-\\*\\/])(-?\\d*\\.?\\d+)";

    private final Pattern validator;
    private final Pattern splitter;

    public RegexParser() {
        validator = Pattern.compile(REGEX_VALIDATION);
        splitter = Pattern.compile(REGEX_SPLIT);
    }

    @Override
    public CommandUnit parseLogic(String expression) {

        CommandUnit commandUnit = new CommandUnit();
        Matcher matcher = splitter.matcher("P" + expression);
        matcher.results().forEach(
                matchResult -> {
                    addOpcode(commandUnit, matchResult);
                    addNumber(commandUnit, matchResult);
                }
        );
        return commandUnit;
    }

    private void addOpcode(CommandUnit commandUnit, MatchResult mr) {
        Opcode.of(mr.group(1).charAt(0))
                .ifPresent(commandUnit::addOpcode);
    }

    private void addNumber(CommandUnit commandUnit, MatchResult mr) {
        String number = mr.group(2);
        if (number.contains(".")) {
            commandUnit.addNumber(Double.valueOf(number));
        } else {
            commandUnit.addNumber(Long.valueOf(number));
        }
    }

    @Override
    protected void checkIsValidExpression(String in) {
        if (!validator.matcher(in).matches()) {
            throw new PatternSyntaxException("올바른 표현식이 아닙니다.", null, -1);
        }
    }
}
