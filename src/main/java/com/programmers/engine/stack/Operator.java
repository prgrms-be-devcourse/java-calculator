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
    DIV("/"),
    NOT_OPERATOR("Not Operator");
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
    public static Optional<Operator> find(String symbol){
        if (map.containsKey(symbol))
            return Optional.of(map.get(symbol));
        else
            return Optional.empty();
    }
}
