import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Option {
    INQUIRY(1),CALCULATE(2);

    private final int select;

    Option(int select) {
        this.select = select;
    }
    static Option parse(String input) {
        return Arrays.stream(Option.values())
                .filter(e -> e.select==toInt(input))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("1,2 중 선택해야 합니다"));
    }

    static int toInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해야 합니다.");
        }
    }

}
