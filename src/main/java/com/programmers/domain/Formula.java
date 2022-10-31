package com.programmers.domain;

import java.util.Objects;

public class Formula {
    private Answer answer;
    private Problem problem;

    private static final String MIDDLEMAN = " = ";

    public Formula(String problem, int answer) {
        this.problem = new Problem(problem);
        this.answer = new Answer(answer);
    }

    public String getFormula() {
        return problem.getProblem() + MIDDLEMAN + answer.getAnswer();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula1 = (Formula) o;
        return Objects.equals(answer, formula1.answer) && Objects.equals(problem, formula1.problem) && Objects.equals(getFormula(), formula1.getFormula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, problem, getFormula());
    }
}
