package com.bona.javacalculator.service;

import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.model.InputAndAnswer;
import com.bona.javacalculator.repository.CalMemoryRepository;

import java.util.List;

public class InquiryService {
    private final CalMemoryRepository calMemoryRepo = new CalMemoryRepository();
    private final Console console = new Console();

    public void inquiry() {
        List<InputAndAnswer> all = calMemoryRepo.findAll();
        if (all.isEmpty()) {
            console.printMessage("조회 결과 기록이 존재하지 않습니다");
            return;
        }
        console.printAll(all);

    }
}
