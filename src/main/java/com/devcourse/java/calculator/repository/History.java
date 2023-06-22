package com.devcourse.java.calculator.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class History {
    private Optional<String> equation;
    private Optional<String> answer;
}
