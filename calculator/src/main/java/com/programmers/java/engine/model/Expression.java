package com.programmers.java.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Expression {
    List<String> operators;
    List<Double> numbers;
}
