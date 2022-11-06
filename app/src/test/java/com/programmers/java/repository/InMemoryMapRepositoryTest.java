package com.programmers.java.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryMapRepositoryTest {

    InMemoryMapRepository inMemoryMapRepository;

    @BeforeEach
    void clear() {
        inMemoryMapRepository = new InMemoryMapRepository();
    }

    @Test
    void save_test() {
        inMemoryMapRepository.save("1 - 1", 1);
        assertEquals(inMemoryMapRepository.findOne("1 - 1").get(), 1);
    }

    @Test
    void findAll_test() {
        inMemoryMapRepository.save("1 - 1", 1);
        inMemoryMapRepository.save("1 + 2", 3);
        inMemoryMapRepository.save("1 + 1 + 2 + 1", 5);

        assertEquals(inMemoryMapRepository.findAll().get("1 - 1"), 1);
        assertEquals(inMemoryMapRepository.findAll().get("1 + 2"), 3);
        assertEquals(inMemoryMapRepository.findAll().get("1 + 1 + 2 + 1"), 5);
    }

    @Test
    void findOne_test() {
        assertEquals(inMemoryMapRepository.findOne(" "), Optional.empty());

        inMemoryMapRepository.save("1 + 1", 2);
        assertEquals(inMemoryMapRepository.findOne("1 + 1").get(), 2);

    }
}