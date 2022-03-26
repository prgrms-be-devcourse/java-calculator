package com.waterfogsw.service;

import com.waterfogsw.AppConfig;
import com.waterfogsw.domain.Calculation;
import com.waterfogsw.service.HistoryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HistoryServiceTest {
    private HistoryService historyService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        historyService = appConfig.historyService();
    }
    
    @Test
    public void 저장_테스트() throws Exception {
        // given
        String expr1 = "2 + 2 + 2";
        String results1 = "6";

        // when
        historyService.save(expr1, results1);
        List<Calculation> findCals = historyService.findAll();

        // then
        Assertions.assertThat(findCals.get(0).toString()).isEqualTo("2 + 2 + 2 = 6");
    }

    @Test
    public void 조회_테스트() throws Exception {
        // given
        String expr1 = "2 + 2 + 2";
        String results1 = "6";

        String expr2 = "2 + 2 + 3";
        String results2 = "7";

        // when
        historyService.save(expr1, results1);
        historyService.save(expr2, results2);
        List<Calculation> calculations = historyService.findAll();

        // then
        Assertions.assertThat(calculations.size()).isEqualTo(2);
    }
}