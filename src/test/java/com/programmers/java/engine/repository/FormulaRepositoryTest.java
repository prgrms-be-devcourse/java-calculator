package com.programmers.java.engine.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;

public class FormulaRepositoryTest {
    private static FormulaRepository formulaRepository = new FormulaRepository();
    final static String TESTFORMULA = "1 + 2";
    final static long TESTRESULT = 3;
    @Test @BeforeEach
    public void 식과_결과가들어오면_testHistory와_history가_같아야함() {
        //given
        LinkedHashMap<String, Long> testHistory = new LinkedHashMap<>();
        //when
        testHistory.put(TESTFORMULA,TESTRESULT);
        formulaRepository.save(TESTFORMULA,TESTRESULT);
        //then
        Assertions.assertEquals(testHistory.get(TESTFORMULA), formulaRepository.getHistory().get(TESTFORMULA));
    }

    @Test
    public void history에_저장된_모든값이_출력되어야함 () {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String resultOutput[] = {TESTFORMULA + " = "+TESTRESULT };
        //when
        formulaRepository.findAll();
        String testOutput[] = out.toString().split("\n");
        //ten
        for (int i = 0; i < resultOutput.length; i++) {
            Assertions.assertEquals(resultOutput[i], testOutput[i].trim());

        }
    }

    @Test
    public void history에_저장된_계산이력_크기인_1이_나와야함() {
        //given
        int resultSize = 1;
        //when
        int testSize = formulaRepository.size();
        //then
        Assertions.assertEquals(resultSize,testSize);
    }

}
