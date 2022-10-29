package com.programmers.java.engine.history;

import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.EquationRecord;
import com.programmers.java.engine.model.StringExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryInMemoryRepositoryImplTest {

    private static HistoryRepository historyRepository = new HistoryInMemoryRepositoryImpl() ;

    @Test
    public void 저장_테스트() {
        //given
        Equation equation = Equation.builder()
                .expression(
                        StringExpression.builder()
                                .value("1 + 3 - 2")
                                .build()
                )
                .answer(
                        Answer.builder()
                                .value(2.0)
                                .build()
                )
                .build();

        //when
        Equation savedEquation = historyRepository.save(equation);

        //then
        assertEquals(equation, savedEquation);
        assertEquals(equation, savedEquation);
    }

    @Test
    public void 조회_테스트() {
        //given
        Equation equation1 = Equation.builder()
                .expression(
                        StringExpression.builder()
                                .value("1 + 3 - 2")
                                .build()
                )
                .answer(
                        Answer.builder()
                                .value(2.0)
                                .build()
                )
                .build();
        Equation equation2 = Equation.builder()
                .expression(
                        StringExpression.builder()
                                .value("1 + 3 - 2 / 2")
                                .build()
                )
                .answer(
                        Answer.builder()
                                .value(3.0)
                                .build()
                )
                .build();
        historyRepository.save(equation1);
        historyRepository.save(equation2);
        Equation[] equations = new Equation[]{equation1, equation2};


        //when
        EquationRecord record = historyRepository.findAll();

        //then
        assertArrayEquals(record.getRecord().toArray(), equations);
    }

}