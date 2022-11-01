package app.calculator;

public class Answer {

    private final Integer correctAnswer;

    private Answer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public static Answer createAbnormalAnswer() {
        return new Answer(null);
    }

    public static Answer createCorrectAnswer(Integer correctAnswer) {
        return new Answer(correctAnswer);
    }

    public boolean isCorrectAnswer() {
        return this.correctAnswer != null;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }
}
