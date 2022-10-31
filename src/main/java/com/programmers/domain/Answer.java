package com.programmers.domain;

import java.util.Objects;

public class Answer {
    private int answer;

    public Answer(int answer) {
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return answer == answer1.answer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }
}
