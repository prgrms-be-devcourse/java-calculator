package com.programmers.oop.service;

import com.programmers.oop.repository.ComputeHistoryRepositoryImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ServiceTest {

    private final static String expression1 = "1 + 2 * 3";
    private final static String realAnswer1 = "7";
    private final static String expression2 = "(1 + 2) * 3";
    private final static String realAnswer2 = "9";
    private LookUpService<String> lookUpService;
    private ComputeService<String> computeService;
    private ComputeHistoryRepositoryImpl respository;

    @BeforeEach
    public void before() {
        //given
        respository = new ComputeHistoryRepositoryImpl();
        lookUpService = new Service(new ComputeHistoryRepositoryImpl());
        computeService = new Service(respository);
    }

    @Test
    @DisplayName("계산 결과")
    void computeExpression() {
        //given

        //when
        String answer1 = computeService.computeExpression(expression1);
        String answer2 = computeService.computeExpression(expression2);

        //then
        Assertions.assertEquals(answer1, realAnswer1);
        Assertions.assertEquals(answer2, realAnswer2);

    }

    @Test
    @DisplayName("계산된 이력 조회")
    void findByAll() {

        //given
        List<String> answersForPredication = List.of(expression1 + " = " + realAnswer1,
            expression2 + " = " + realAnswer2);
        respository.save(expression1 + " = " + realAnswer1);
        respository.save(expression2 + " = " + realAnswer2);
        //when
        List<String> answers = respository.findAll();
        //then
        for (int i = 0; i < answers.size(); i++) {
            Assertions.assertEquals(answersForPredication.get(i), answers.get(i));
        }
    }
}