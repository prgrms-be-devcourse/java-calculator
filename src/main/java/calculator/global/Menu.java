package calculator.global;

public enum Menu {
    EXIT('0', "종료"),
    CALCULATION_HISTORY('1', "조회"),
    CALCULATE('2', "계산");

    private final Character command;
    private final String explanation;


    Menu(Character command, String explanation) {
        this.command = command;
        this.explanation = explanation;
    }

    public Character getCommand(){
        return command;
    }

    @Override
    public String toString() {
        return command + ". " + explanation;
    }
}
