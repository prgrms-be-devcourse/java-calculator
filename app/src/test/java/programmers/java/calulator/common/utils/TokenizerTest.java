package programmers.java.calulator.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    @Test
    @DisplayName("문자열을 입력 받았을 때 띄워쓰기 별로 분리가 잘 되는지 확인하는 테스트")
    public void 문자열_분리_테스트() {
        //given
        String expression = "10 + 20";

        //when
        Tokenizer tokenizer = new Tokenizer(expression);
        String[] tokens = tokenizer.getTokens();

        //then
        assertEquals(3, tokens.length);
        assertEquals("10", tokens[0]);
        assertEquals("+", tokens[1]);
        assertEquals("20", tokens[2]);
    }
}
