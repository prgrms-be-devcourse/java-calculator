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

    @Test
    public void 더하기연산(){
        Problem problem = new Problem();
        int answer = problem.makeQuestionArray("1 + 2 + 3 + 4 + 5").calculate().getAnswer();
        Assertions.assertEquals(answer,15);
    }

    @Test
    public void 마이너스연산(){
        Problem problem = new Problem();
        int answer = problem.makeQuestionArray("0 - 1 - 2 - 3 - 4 - 5").calculate().getAnswer();
        Assertions.assertEquals(answer,-15);
    }

    @Test
    public void 곱하기연산(){
        Problem problem = new Problem();
        int answer = problem.makeQuestionArray("1 * 2 * 3 * 4 * 5").calculate().getAnswer();
        Assertions.assertEquals(answer,120);
    }

    @Test
    public void 나누기연산(){
        Problem problem = new Problem();
        int answer = problem.makeQuestionArray("120 / 5 / 4 / 3 / 2").calculate().getAnswer();
        Assertions.assertEquals(answer,1);
    }

    @Test
    public void 맨앞이마이너스일경우(){
        Problem problem = new Problem();
        int answer = problem.makeQuestionArray("-120 + 130 *2").calculate().getAnswer();
        Assertions.assertEquals(answer,140);
    }

    @Test
    public void 사칙연산적용(){
        Problem problem = new Problem();
        int answer = problem.makeQuestionArray("1 + 2 * 3 / 2 - 3").calculate().getAnswer();
        Assertions.assertEquals(answer,1);
    }

    @Test
    public void 사칙연산적용2(){
        Problem problem = new Problem();
        int answer = problem.makeQuestionArray("-1 + 2 * 3 / 2 - 3").calculate().getAnswer();
        Assertions.assertEquals(answer,-1);
    }
}