package com.programmers.calculator.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Parser 테스트")
public class ParserTest {
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = Parser.getInstance();
    }

    @DisplayName("parse() 테스트")
    @Nested
    class ParseTest {
        @DisplayName("연산자&숫자 분리 성공 사례")
        @Test
        void testParseSuccess() {
            List<DataForParse> list = new ArrayList<>();
            list.add(new DataForParse("1+2", new String[]{"1", "+", "2"}));
            list.add(new DataForParse("1 / 2 +3", new String[]{"1", "/", "2", "+", "3"}));
            list.add(new DataForParse("(1.1+2) /3", new String[]{"(", "1.1", "+", "2", ")", "/", "3"}));
            list.add(new DataForParse("1-2 * 3", new String[]{"1", "-", "2", "*", "3"}));
            list.add(new DataForParse("1 + ( 2 - 3 ) * 4 + 5", new String[]{"1", "+", "(", "2", "-", "3", ")", "*", "4", "+", "5"}));

            list.forEach(mockData -> assertArrayEquals(mockData.getResult(), parser.parse(mockData.getOrigin())));
        }

        @DisplayName("연산자&숫자 분리 실패 사례")
        @Test
        void testParseFail() {
            List<DataForParse> list = new ArrayList<>();
            list.add(new DataForParse("1&2", new String[]{"1&2"}));
            list.add(new DataForParse("1 & 2 ^3", new String[]{"1&2^3"}));
            list.add(new DataForParse("[1.1+2] /3", new String[]{"[1.1", "+", "2]", "/", "3"}));

            list.forEach(mockData -> assertArrayEquals(mockData.getResult(), parser.parse(mockData.getOrigin())));
        }
    }

    @DisplayName("getPostfix() 테스트")
    @Nested
    class GetPostfixTest {
        @DisplayName("중위 표기식 후위 표기식으로 변경")
        @Test
        void testGetPostfixSuccess() {
            List<DataForPostfix> list = new ArrayList<>();
            list.add(new DataForPostfix(new String[]{"1", "+", "2"}, new String[]{"1", "2", "+"}));
            list.add(new DataForPostfix(new String[]{"1", "/", "2", "+", "3"}, new String[]{"1", "2", "/", "3", "+"}));
            list.add(new DataForPostfix(new String[]{"(", "1.1", "+", "2", ")", "/", "3"}, new String[]{"1.1", "2", "+", "3", "/"}));
            list.add(new DataForPostfix(new String[]{"1", "-", "2", "*", "3"}, new String[]{"1", "2", "3", "*", "-"}));
            list.add(new DataForPostfix(new String[]{"1", "+", "(", "2", "-", "3", ")", "*", "4", "+", "5"}, new String[]{"1", "2", "3", "-", "4", "*", "5", "+", "+"}));

            list.forEach(mockData -> assertArrayEquals(mockData.getResult(), parser.getPostfix(mockData.getOrigin())));
        }
    }

    static class DataForParse {
        private final String origin;
        private final String[] result;

        public DataForParse(String origin, String[] result) {
            this.origin = origin;
            this.result = result;
        }

        public String getOrigin() {
            return origin;
        }

        public String[] getResult() {
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataForParse mockData = (DataForParse) o;
            return Objects.equals(origin, mockData.origin) && Arrays.equals(result, mockData.result);
        }

        @Override
        public int hashCode() {
            int result1 = Objects.hash(origin);
            result1 = 31 * result1 + Arrays.hashCode(result);
            return result1;
        }
    }

    static class DataForPostfix {
        private final String[] origin;
        private final String[] result;

        public DataForPostfix(String[] origin, String[] result) {
            this.origin = origin;
            this.result = result;
        }

        public String[] getOrigin() {
            return origin;
        }

        public String[] getResult() {
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataForPostfix that = (DataForPostfix) o;
            return Arrays.equals(origin, that.origin) && Arrays.equals(result, that.result);
        }

        @Override
        public int hashCode() {
            int result1 = Arrays.hashCode(origin);
            result1 = 31 * result1 + Arrays.hashCode(result);
            return result1;
        }
    }
}
