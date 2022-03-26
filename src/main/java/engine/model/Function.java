package engine.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Function {
    private Map<Integer, String> function;

    public Function() {
        this.function = new HashMap<>();
        function.put(1, "1. 조회");
        function.put(2, "2. 계산");
    }

    public void indexForEach(Consumer<String> consumer) {
        for (int i = 1; i < function.size() + 1; i++) {
            consumer.accept(function.get(i));
        }
    }

}
