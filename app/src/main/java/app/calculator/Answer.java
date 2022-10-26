package app.calculator;

/* 계산 결과를 반환할 타입을 정의한 클래스입니다.
올바른 값을 반환한다면 correctAnswer에, 올바르지 않은 값을 반환한다면 abnormalAnswer에
값을 가지는 클래스를 생성합니다.
 */
public class Answer {
    private Integer correctAnswer;
    private String abnormalAnswer;

    private Answer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    private Answer() {
        this.abnormalAnswer = "ABNORMAL_ANSWER";
    }

    public static Answer createAbnormalAnswer() {
        return new Answer();
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
