package com.programmers.cal;

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
        List<String> postfix1 = postfix.toPostfix(input1);
        List<String> postfix2 = postfix.toPostfix(input2);
        List<String> postfix3 = postfix.toPostfix(input3);
        List<String> postfix4 = postfix.toPostfix(input4);

        //then
        assertThat(postfix1).isEqualTo(expected1);
        assertThat(postfix2).isEqualTo(expected2);
        assertThat(postfix3).isEqualTo(expected3);
        assertThat(postfix4).isEqualTo(expected4);
    }
}