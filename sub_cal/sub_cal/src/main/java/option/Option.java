package option;

import java.util.Arrays;
import java.util.Optional;


public enum Option {
    HISTORY("1","조회"),
    CALCULATE("2","계산");

    private final String option;
    private final String index;

    Option(String option,String index) {
        this.option = option;
        this.index = index;
    }

    @Override
    public String toString() {
        return option + '.' + index ;
    }

    public static Optional<Option> getMenu(String option) {
        return Arrays.stream(values())
                .filter(o -> o.option.equals(option))
                .findFirst();
    }
}
