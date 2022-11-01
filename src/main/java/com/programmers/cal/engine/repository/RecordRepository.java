package com.programmers.cal.engine.repository;

import com.programmers.cal.engine.exception.NoRecordException;
import com.programmers.cal.engine.model.Equation;
import com.programmers.cal.engine.model.InputData;
import com.programmers.cal.engine.model.Record;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecordRepository implements Repository {

    private static final Map<InputData, Equation> map = new LinkedHashMap<>();

    @Override
    public void save(Equation equation) {
        map.put(equation.getInputData(), equation);
    }

    @Override
    public Record findAll() {
        if(map == null || map.isEmpty()){
            throw new NoRecordException();
        }

        List<Equation> recordList = map.values().stream()
                .collect(Collectors.toList());

        return Record.builder()
                .equations(recordList)
                .build();
    }
}
