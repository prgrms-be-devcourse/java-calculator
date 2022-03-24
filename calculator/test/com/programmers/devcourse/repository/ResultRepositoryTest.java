package com.programmers.devcourse.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultRepositoryTest {

  static ResultRepository<String, Double> repository;

  @BeforeAll
  static void setup() {
    repository = new StringResultRepository();
  }


  @BeforeEach
  void settingUpRepositoryData() {
    repository.save("1 + 1", 2.0);

    repository.save("2 + 2", 4.0);
    repository.save("3 + 3", 5.0);
  }

  @Test
  void testGetSizeReturn3() {
    assertEquals(repository.getSize(), 3);
  }

  @Test
  void testSaveAndGetAllResultsReturnSavedData() {

    assertTrue(
        repository.getAllResults().keySet().containsAll(Arrays.asList("1 + 1", "2 + 2", "3 + 3")) &&
            repository.getAllResults().values().containsAll(Arrays.asList(2.0, 4.0, 5.0)));

  }
}