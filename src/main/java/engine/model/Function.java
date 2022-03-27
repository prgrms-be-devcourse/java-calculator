package engine.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.LongStream;

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

    public Optional<Integer> check(String s){
        long count = s.chars().filter(Character::isDigit)
                .map(Character::getNumericValue)
                .count();
        if(count == 0) return Optional.empty();

        int functionNumber = Integer.parseInt(Arrays.toString(s.chars()
                .map(Character::getNumericValue).toArray()).replaceAll("[^0-9]",""));

        if(function.containsKey(functionNumber)) return Optional.of(functionNumber);
        return Optional.empty();
    }

}
