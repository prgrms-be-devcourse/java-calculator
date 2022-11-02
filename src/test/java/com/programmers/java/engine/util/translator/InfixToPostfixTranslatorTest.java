package com.programmers.java.engine.util.translator;

import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InfixToPostfixTranslatorTest {
    @Test
    @DisplayName("중위 표현식을 후위 표현식으로 잘 바뀌어 출력되는지 테스트")
    public void infixToPostfixTranslateTest() {
        Translator translator = new InfixToPostfixTranslator();
        Expression infix = new Expression("3 + 5 * 2 / ( 7 - 2 )");
        Expression postfix = translator.translate(infix);

        Assertions.assertEquals(postfix.toString(), "3 5 2 * 7 2 - / + ");
    }
}
