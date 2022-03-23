package com.programmers.devcourse.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

class ResultRepositoryTest {

  static ResultRepository<String> repository;

  @BeforeAll
  static void setup() {
    repository = new StringResultRepository();
  }

  @Test
  void testSaveAndGetSizeShouldReturnOne() {
    repository.save("Hello");
    Assertions.assertEquals(repository.getSize(), 1);
  }

  @Test
  void testSaveAndGetAllResultsShouldReturnSavedData() {
    repository.save("Hello2");
    repository.save("Hello3");
    Assertions.assertArrayEquals(repository.getAllResults(), new String[]{"Hello2", "Hello3"});

    Assertions.assertThrows(AssertionFailedError.class, () -> {
      Assertions.assertArrayEquals(repository.getAllResults(),
          new String[]{"Hello2", "Hello3", "Hello4"});
    });

  }
}