package com.programmers.java.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Expression {
    String[] operators;
    Integer[] numbers;
}
