package example.calculator.model;

public enum Menu {
    조회(1),
    계산(2);

    private final int value;

    Menu(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
