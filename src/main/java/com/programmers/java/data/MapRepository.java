package com.programmers.java.data;

import com.programmers.java.io.Output;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class MapRepository implements Repository {
    private Map<String, Double> repo;

    public MapRepository() {
        this.repo = new HashMap<>();
    }

    public Double getOneResult(String s) {
        return repo.get(s);
    }

    public boolean contain(String s) {
        return repo.containsKey(s);
    }

    public void save(Result res) {
        Double answer = res.getAnswer();
        String exp = res.getExp();
        repo.put(exp, answer);
    }

    public void getAllResult(Output output) {
        if (repo.isEmpty()) output.putResult("계산 이력이 없습니다.");
        repo.forEach((key, value) -> {
            if (value == value.intValue())
                output.putResult(makeExpressionFormat(key) + "= " + value.intValue());
            else output.putResult(makeExpressionFormat(key) + "= " + value);
        });
    }

    private String makeExpressionFormat(String s) {
        return Arrays.stream(s.replace(" ", "").split(""))
                .map(i -> i + " ")
                .collect(Collectors.joining(""));
    }
}

