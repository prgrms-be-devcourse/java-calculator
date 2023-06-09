package calculator.global;

public enum Menu {
    GET(1, "조회"),
    CALCULATE(2, "계산");

    private final Integer command;
    private final String explanation;


    Menu(Integer command, String explanation) {
        this.command = command;
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return command + ". " + explanation;
    }
}
