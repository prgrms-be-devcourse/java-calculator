package app.calculator;

public class Answer {

    private final Integer correctAnswer;

    private Answer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public static Answer createCorrectAnswer(Integer correctAnswer) {
        return new Answer(correctAnswer);
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }
}
