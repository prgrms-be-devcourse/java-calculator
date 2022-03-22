package com.programmers;

import com.programmers.repository.CaseRepository;
import com.programmers.repository.MemoryRepository;
import com.programmers.service.MainService;

public class AppConfig {

    public MainService mainService(){
        return new MainService(memoryRepository());
    }

    // memoryRepository 연동
    private CaseRepository memoryRepository() {
        return new MemoryRepository();
    }
}
