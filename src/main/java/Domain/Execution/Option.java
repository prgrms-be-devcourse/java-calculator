package Domain.Execution;

import java.util.Arrays;

public enum Option {
    INQUIRY(1), CALCULATE(2), NONE(-1);

    private final int choice;

    Option(int choice) {
        this.choice = choice;
    }

    public static Option from(int choice) {
        return Arrays.stream(values())
                .filter(x -> x.choice == choice)
                .findAny()
                .orElse(NONE);
    }

    public Execution convert() {
        switch (this) {
            case INQUIRY:
                return new Inquiry();
            case CALCULATE:
                return new Calculate();
            default:
                return new None();
        }
    }
}
