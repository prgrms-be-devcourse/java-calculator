package org.example.domain;

public class Calculator {

    private ExpressionConvertor expressionConvertor = new ExpressionConvertor();
    private Processor processor = new Processor();
    private Memory memory = new Memory();

    public Integer run(String expression) {
        Integer result = processor.calculate(expressionConvertor.convertToPostfix(expression));

        memory.save(expression, result);
        return result;
    }
}
