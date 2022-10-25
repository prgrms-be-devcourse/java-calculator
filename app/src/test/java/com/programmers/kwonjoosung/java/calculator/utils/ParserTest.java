package com.programmers.kwonjoosung.java.calculator.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
        static Parser parser;

        @BeforeAll
        @DisplayName("시작")
        static void setParser(){
            parser = new BasicParser();
        }

        @Test
        @DisplayName("연산식 오류")
        void incorrect1(){
            // given
            String expression = "1 + 1 - ";
            //when & then
            assertThrows(IllegalArgumentException.class,() -> parser.parsing(expression));
        }
        @Test
        @DisplayName("올바르지 못한 연산자")
        void incorrect3(){
            // given
            String expression = "1 + 1 = 2";
            //when & then
            assertThrows(IllegalArgumentException.class,() -> parser.parsing(expression));
        }
        @Test
        @DisplayName("빈 값")
        void incorrect4(){
            // given
            String expression = "";
            //when & then
            assertThrows(IllegalArgumentException.class,() -> parser.parsing(expression));
        }
        @Test
        @DisplayName("올바르지 않은 연산자 순서")
        void incorrect5() {
            // given
            String expression = "1 * * 1";
            //when & then
            assertThrows(IllegalArgumentException.class,() -> parser.parsing(expression));
        }
        @Test
        @DisplayName("올바르지 않은 연산자 순서")
        void incorrect6() {
            // given
            String expression = "1 1 *";
            //when & then
            assertThrows(IllegalArgumentException.class,() -> parser.parsing(expression));
        }
        @Test
        @DisplayName("올바른 입력")
        void correct1() {
            // given
            String expression = "11 + 12 - 13 + -14 / 15.5";
            String[] answer = new String[]{"11", "+", "12", "-", "13", "+", "-14", "/", "15.5"};
            //when
            String[] result = parser.parsing(expression);
            //then
            boolean valid = false;
            for(int i=0; i<answer.length;i++){
                valid = answer[i].equals(result[i]);
                if(!valid) break;
            }
            assertTrue(valid);
        }
        @Test
        @DisplayName("스페이스 오타")
        void correct2(){
            // given
            String expression = "1 +          1        ";
            // when
            String[] answer = new String[]{"1","+","1"};
            String[] result = parser.parsing(expression);
            // then
            boolean valid = false;
            for(int i=0; i<answer.length;i++){
                valid = answer[i].equals(result[i]);
                if(!valid) break;
            }
            assertTrue(valid);
        }
}
