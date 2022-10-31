package com.programmers.domain;

import java.util.Objects;

public class Problem {
    private String problem;

    public Problem(String problem) {
        this.problem = problem;
    }

    public String getProblem() {
        return problem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem1 = (Problem) o;
        return Objects.equals(problem, problem1.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problem);
    }
}
