package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.enums.MenuNumber;
import com.kimhunki.java.calculator.enums.Operations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser parser = new Parser();
    @Test
    @DisplayName("메뉴 파싱 테스트")
    void menuParser( ) {
        assertEquals(MenuNumber.ONE,parser.menuParser("1"));
        assertEquals(MenuNumber.TWO,parser.menuParser("2"));
        assertEquals(MenuNumber.THREE,parser.menuParser("3"));
        assertEquals(MenuNumber.NOTNUM,parser.menuParser("weqr"));
        assertEquals(MenuNumber.NOTNUM,parser.menuParser("4"));
        assertEquals(MenuNumber.NOTNUM,parser.menuParser("15"));
    }

    @Test
    @DisplayName("식 파싱해서 리스트에 넣어주는 테스트")
    void expressionParser( ) {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("2", "+", "3","-","5"));

        assertEquals(arrayList1,parser.expressionParser("2+3-5"));

    }

    @Test
    @DisplayName("부호 파싱 테스트")
    void operParser( ) {
        assertEquals(Operations.PLUS,parser.operParser("+"));
        assertEquals(Operations.MINUS,parser.operParser("-"));
        assertEquals(Operations.MUL,parser.operParser("*"));
        assertEquals(Operations.DIV,parser.operParser("/"));
    }
}