package option;

import java.util.Arrays;
import java.util.Optional;

//사용자가 선택할 수 있는 옵션을 가지고 있는 enum 클래스입니다.
public enum Option {
    HISTORY("1","조회"),
    CALCULATE("2","계산");

    private final String option;
    private final String index;

    Option(String option,String index) {
        this.option = option;
        this.index = index;
    }



    public static Optional<Option> getMenu(String option) {
        return Arrays.stream(values())
                .filter(o -> o.option.equals(option))
                .findFirst();
    }
}
