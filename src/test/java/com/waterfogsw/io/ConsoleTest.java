package com.waterfogsw.io;

import com.waterfogsw.AppConfig;
import org.junit.jupiter.api.BeforeEach;

class ConsoleTest {
    private Input input;
    private Output output;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        input = appConfig.console();
        output = appConfig.console();
    }
}