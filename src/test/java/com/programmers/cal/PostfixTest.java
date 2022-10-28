package com.programmers.cal;

import com.programmers.cal.engine.model.OriginalExpression;
import com.programmers.cal.engine.model.PostfixExpression;
import com.programmers.cal.engine.postfix.Postfix;
import com.programmers.cal.engine.postfix.PostfixManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PostfixTest {

    Postfix postfix = new PostfixManager();

    @Test
    @DisplayName("후위표기법 변환 성공")
    public void successPostfix() {
        //given
        List<String> input1 = Arrays.asList("12", "+", "3", "*", "45", "/", "2");
        List<String> input2 = Arrays.asList("12", "+", "-34", "*", "2");
        List<String> input3 = Arrays.asList("-12", "+", "-32", "/", "-4");
        List<String> input4 = Arrays.asList("-12", "+", "-32", "/", "-4", "+", "32", "*", "2");

        List<String> expected1 = Arrays.asList("12", "3", "45", "*", "2", "/", "+");
        List<String> expected2 = Arrays.asList("12", "-34", "2", "*", "+");
        List<String> expected3 = Arrays.asList("-12", "-32", "-4", "/", "+");
        List<String> expected4 = Arrays.asList("-12", "-32", "-4", "/", "+", "32", "2", "*", "+");

        //when
        PostfixExpression postfix1 = postfix.toPostfix(OriginalExpression.builder()
                .originalTokens(input1)
                .build());

        PostfixExpression postfix2 = postfix.toPostfix(OriginalExpression.builder()
                .originalTokens(input2)
                .build());

        PostfixExpression postfix3 = postfix.toPostfix(OriginalExpression.builder()
                .originalTokens(input3)
                .build());

        PostfixExpression postfix4 = postfix.toPostfix(OriginalExpression.builder()
                .originalTokens(input4)
                .build());

        //then
        assertThat(postfix1.getPostfixTokens()).isEqualTo(expected1);
        assertThat(postfix2).isEqualTo(expected2);
        assertThat(postfix3).isEqualTo(expected3);
        assertThat(postfix4).isEqualTo(expected4);
    }
}