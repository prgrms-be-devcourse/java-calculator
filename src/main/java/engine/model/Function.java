package engine.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.LongStream;

public class Function {
    private Map<String, String> function;

    public Function() {
        this.function = new HashMap<>();
        function.put("1", "1. 조회");
        function.put("2", "2. 계산");
    }

    public boolean hasFunction(String functionNumber) {
        return function.containsKey(functionNumber.trim());
    }

    public void indexForEach(Consumer<String> consumer) {
        for (int i = 1; i < function.size() + 1; i++) {
            consumer.accept(function.get(i + ""));
        }
    }

}
