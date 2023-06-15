package example.calculator.model;
public enum Menu {
    조회(1, "조회"),
    계산(2, "계산");

    private final int value;
    private final String name;

    Menu(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getFormattedInfo() {
        return value + ". " + name;
    }
}

