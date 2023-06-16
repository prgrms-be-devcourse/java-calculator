package org.example;

public enum Choice {
    HISTORY(1), CALCULATION(2), END(3),WRONGNUMBER(4);

    private final int inputValue;
    private static final Choice[] CHOICES = Choice.values();

    Choice(int inputValue) {
        this.inputValue = inputValue;
    }

    public static Choice of(int inputValue) {
        if (inputValue < 1 || inputValue > 3) {
            return CHOICES[3];
        }
        return CHOICES[inputValue - 1];
    }
}
