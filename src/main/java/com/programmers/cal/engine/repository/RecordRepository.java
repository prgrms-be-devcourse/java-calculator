package com.programmers.cal.engine.repository;

import com.programmers.cal.engine.model.Answer;
import com.programmers.cal.engine.model.Equation;
import com.programmers.cal.engine.model.InputData;
import com.programmers.cal.engine.model.Record;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecordRepository implements Repository {

    private static final Map<InputData, Answer> map = new LinkedHashMap<>();

    @Override
    public void save(Equation equation) {
        map.put(equation.getInputData(), equation.getAnswer());
    }

    @Override
    public Record findAll() {
        List<Equation> recordList = new ArrayList<>();

        map.forEach((key, value) -> {
            recordList.add(Equation.builder()
                    .inputData(key)
                    .answer(value)
                    .build());
        });

        return Record.builder()
                .equations(recordList)
                .build();
    }
}
