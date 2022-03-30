package com.programmers;

import com.programmers.store.CaseStore;
import com.programmers.store.MemoryStore;
import com.programmers.service.MainService;

public class AppConfig {

    public MainService mainService() {
        return new MainService(memoryRepository());
    }

    // memoryRepository 연동
    private CaseStore memoryRepository() {
        return new MemoryStore();
    }
}
