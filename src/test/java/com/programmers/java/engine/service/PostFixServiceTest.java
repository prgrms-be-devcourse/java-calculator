package com.programmers.java.engine.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostFixServiceTest {
    PostFixService postFixService = new PostFixService();

    @Test
    public void 연산자가_잘못된_입력일경우_IllegalStateException발생_해야함() {
        //given
        String errorOperator = "%";
        //when
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            postFixService.OperatorPriority(errorOperator);
        });
    }
}
