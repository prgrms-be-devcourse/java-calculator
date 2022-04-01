package engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@AllArgsConstructor
@Getter
public class Element {
    private List<Character> calculateOperators = Arrays.asList('+', '-', '*', '/');
    private Stack<Character> operation;
    private Stack<Integer> numbers;

    public Element(Stack<Integer> numbers, Stack<Character> operation) {
        this.numbers = numbers;
        this.operation = operation;
    }
}
