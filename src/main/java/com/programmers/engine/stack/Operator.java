package com.programmers.engine.stack;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/");

    private final String symbol;

    private static final Map<String, Operator> map =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(
                    Operator::getSymbol, Function.identity()
            )));

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
    public Optional<Operator> find(String symbol){
        if (map.containsKey(symbol))
            return Optional.of(map.get(symbol));
        else
            return Optional.empty();
    }

    public int getPriority(Operator operator){
        if (operator.equals(PLUS) || operator.equals(MINUS))
            return -1;
        else
            return 1;
    }
}
