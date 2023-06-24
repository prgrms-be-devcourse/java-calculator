package option;

import java.util.Arrays;
import java.util.Optional;


public enum Option {
    HISTORY("1","조회","HISTORY"),
    CALCULATE("2","계산","CALCULATE"),
    EXIT("3","종료","EXIT");

    private final String index;
    private final String option;
    private final String menuName;

    Option(String index,String option,String menuName) {
        this.index = index;
        this.option = option;
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public String toString() {
        return index + '.' + option ;
    }

    public static Optional<Option> getMenu(String option) {
        return Arrays.stream(values())
                .filter(o -> o.index.equals(option))
                .findFirst();
    }
}
