package com.programmers.java.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {
    @Test
    public void 입력값을필드값배열로변환1(){
        Problem problem = new Problem();
        problem.makeQuestionArray("11 + 12 * 13 / 2  - 13");

        String[] question = problem.getQuestion();
        List<String> questionArray = Arrays.asList("11","+","12","*","13","/","2","-","13");

        for (int i = 0; i < question.length; i++) {
            Assertions.assertEquals(question[i],questionArray.get(i));
        }
    }

    @Test
    public void 입력값을필드값배열로변환2(){
        Problem problem = new Problem();
        problem.makeQuestionArray("11 + 12 + 13 + 2  - 13");

        String[] question = problem.getQuestion();
        List<String> questionArray = Arrays.asList("11","+","12","+","13","+","2","-","13");

        for (int i = 0; i < question.length; i++) {
            Assertions.assertEquals(question[i],questionArray.get(i));
        }
    }

    @Test
    public void 입력값을필드값배열로변환3(){
        Problem problem = new Problem();
        problem.makeQuestionArray("-11+12+13+2-13");

        String[] question = problem.getQuestion();
        List<String> questionArray = Arrays.asList("","-","11","+","12","+","13","+","2","-","13");

        for (int i = 1; i < question.length; i++) {
            Assertions.assertEquals(question[i],questionArray.get(i));
        }
    }

}