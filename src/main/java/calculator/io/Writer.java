package calculator.io;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Writer {
    public void printSelectOption(List<String> selectOptions) {
        AtomicInteger index = new AtomicInteger();
        selectOptions.forEach(
                option -> System.out.println(toOptionFormat(index.incrementAndGet(), option))
        );
    }

    private String toOptionFormat(int index, String option) {
        return new StringBuilder()
                .append(index)
                .append(Characters.DOT.toLiteral())
                .append(Characters.BLANK.toLiteral())
                .append(option)
                .toString();
    }
}
