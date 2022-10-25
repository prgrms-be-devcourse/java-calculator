package com.programmers.cal;

import com.programmers.cal.engine.Calculator;
import com.programmers.cal.engine.io.Console;
import com.programmers.cal.engine.operation.OperationManager;
import com.programmers.cal.engine.parse.ExpressionParse;
import com.programmers.cal.engine.postfix.PostfixManager;
import com.programmers.cal.engine.repository.RecordRepository;
import com.programmers.cal.engine.validator.ExpressionValidator;

public class Application {
    public static void main(String[] args) {

        Calculator.builder()
                .input(new Console())
                .output(new Console())
                .validator(new ExpressionValidator())
                .parse(new ExpressionParse())
                .postfix(new PostfixManager())
                .operation(new OperationManager())
                .repository(new RecordRepository())
                .build()
                .run();
    }
}