package org.programmers.java.calculator.util.verifiaction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormulaVerificationTest {

    @Test
    @DisplayName("플러스 입력에 대한 검증하라")
    void formulaVerifiactionPlus() {
        //given
        String input = "1 + 1";
        List<String> stringList = Arrays.asList(input.split(" "));

        //when
        FormulaVerification.formulaVerifiaction(stringList);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("마이너스 입력에 대한 검증하라")
    void formulaVerifiactionMinus() {
        //given
        String input = "1 - 1";
        List<String> stringList = Arrays.asList(input.split(" "));

        //when
        FormulaVerification.formulaVerifiaction(stringList);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("곱하기 입력에 대한 검증하라")
    void formulaVerifiactionMultiply() {
        //given
        String input = "1 * 1";
        List<String> stringList = Arrays.asList(input.split(" "));

        //when
        FormulaVerification.formulaVerifiaction(stringList);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("나누기 입력에 대한 검증하라")
    void formulaVerifiactionDivide() {
        //given
        String input = "1 / 1";
        List<String> stringList = Arrays.asList(input.split(" "));


        //when
        FormulaVerification.formulaVerifiaction(stringList);

        //then
        assertEquals(1, 1);
    }

    @Test
    @DisplayName("비정상 연산자 입력에 대한 검증하라")
    void formulaVerifiactionNotPlus() {
        //given
        String input = "1 & 1";
        String input1 = "2 ^^ 2";
        String input2 = "2 2 ^ 2";
        String input3 = "2 2 ^ 2 2";
        String input4 = "2 3 ^ 3 2";
        String input5 = "2 (()) ^ 2";
        String input6 = "99999";
        String input7 = "$##%#%";
        String input8 = "";
        String input9 = "1 + 2 +";

        List<String> stringList = Arrays.asList(input.split(" "));
        List<String> stringList1 = Arrays.asList(input1.split(" "));
        List<String> stringList2 = Arrays.asList(input2.split(" "));
        List<String> stringList3 = Arrays.asList(input3.split(" "));
        List<String> stringList4 = Arrays.asList(input4.split(" "));
        List<String> stringList5 = Arrays.asList(input5.split(" "));
        List<String> stringList6 = Arrays.asList(input6.split(" "));
        List<String> stringList7 = Arrays.asList(input7.split(" "));
        List<String> stringList8 = Arrays.asList(input8.split(" "));
        List<String> stringList9 = Arrays.asList(input9.split(" "));

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList6);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList7);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList8);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FormulaVerification.formulaVerifiaction(stringList9);
        });
    }
}