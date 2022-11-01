package com.programmers.engine.stack;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Bracket {
    OPEN("("),
    CLOSE(")");
    private final String symbol;

    private static final Map<String, Bracket> map =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(
                    Bracket::getSymbol, Function.identity()
            )));

    Bracket(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
    public static Optional<Bracket> find(String symbol){
        if (map.containsKey(symbol))
            return Optional.of(map.get(symbol));
        else
            return Optional.empty();
    }
}
