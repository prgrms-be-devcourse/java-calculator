package service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceImplTest {

    @Test
    void 계산식_입력() {
        ServiceImpl service = new ServiceImpl();
        service.run();
    }
}