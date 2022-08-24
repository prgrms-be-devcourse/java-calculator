package com.programmers.javaCalculator.service;

import com.programmers.javaCalculator.component.InfixToPostfixConverter;
import com.programmers.javaCalculator.component.PostfixCalculator;
import com.programmers.javaCalculator.repository.LocalRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixCalculatorServiceTest {

    PostfixCalculatorService service =
            new PostfixCalculatorService(new PostfixCalculator(),
                    new InfixToPostfixConverter(),
                    new LocalRepository());

    @Test
    @DisplayName("문자열의 앞과 뒤의 공백을 제거하고 두 칸 이상의 공백을 한 칸으로 치환")
    void makeForm() {
        String input = service.makeForm("    1   +  2 * 3         + 5           ");

        assertThat(input).isEqualTo("1 + 2 * 3 + 5");
    }
}