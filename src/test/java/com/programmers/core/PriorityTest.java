package com.programmers.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.programmers.core.Priority.getPriority;
import static com.programmers.core.Priority.isNewOperatorPriorityHigher;
import static com.programmers.core.Priority.isNewOperatorPriorityLower;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PriorityTest {
    @Test
    @DisplayName("올바른 수식의 우선순위 확인")
    void validOperator() {
        assertThat(getPriority("/")).isEqualTo(10);
        assertThat(getPriority("*")).isEqualTo(10);
        assertThat(getPriority("+")).isEqualTo(1);
        assertThat(getPriority("-")).isEqualTo(1);
    }

    @Test
    @DisplayName("잘못된 수식 입력")
    void invalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> Priority.getPriority("@"));
        assertThrows(IllegalArgumentException.class, () -> Priority.getPriority("abc"));
        assertThrows(IllegalArgumentException.class, () -> Priority.getPriority(""));
        assertThrows(IllegalArgumentException.class, () -> Priority.getPriority(null));
    }

    @Test
    @DisplayName("우선순위가 operator > stack 상위")
    void withHigherPriority() {
        Stack<String> operatorStack = new Stack<>();
        operatorStack.push("+");

        assertTrue(isNewOperatorPriorityHigher("/", operatorStack));
        assertTrue(isNewOperatorPriorityHigher("*", operatorStack));

        assertFalse(isNewOperatorPriorityLower("/", operatorStack));
        assertFalse(isNewOperatorPriorityLower("*", operatorStack));
    }


    @Test
    @DisplayName("우선순위가 operator < stack 상위")
    void withLowerPriority() {
        Stack<String> operatorStack = new Stack<>();
        operatorStack.push("*");

        assertTrue(isNewOperatorPriorityLower("-", operatorStack));
        assertTrue(isNewOperatorPriorityLower("+", operatorStack));

        assertFalse(isNewOperatorPriorityHigher("-", operatorStack));
        assertFalse(isNewOperatorPriorityHigher("+", operatorStack));
    }
}