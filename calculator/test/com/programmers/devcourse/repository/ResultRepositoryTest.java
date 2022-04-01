package com.programmers.devcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

class ResultRepositoryTest {

  static String[] expressions = new String[]{"1 + 1", "2 + 2", "3 + 3"};
  static double[] results = new double[]{2.0, 4.0, 6.0};


  ResultRepository<String, Double> repository = new StringResultRepository();

  static Stream<Arguments> expressionAnswerProvider() {
    Stream.Builder<Arguments> builder = Stream.builder();

    for (int i = 0; i < expressions.length; i++) {
      builder.add(Arguments.of(expressions[i], results[i]));

    }

    return builder.build();
  }

  @BeforeEach
  void setUpRepositoryData() {
    for (int i = 0; i < expressions.length; i++) {
      repository.save(expressions[i], results[i]);
    }
  }


  @DisplayName("Repository 에는 3개의 데이터가 저장되어 있어야 한다.")
  @Test
  void testGetSizeReturn3() {
    assertThat(repository.getAll().size()).isEqualTo(3);
  }


  @DisplayName("Repository에 입력한 순서대로 데이터가 저장되어 있어야 한다.")
  @RepeatedTest(5)
  void savedDataShouldHaveRightOrder() {
    AtomicInteger i = new AtomicInteger();

    repository.getAll().forEach((key, value) -> {
      int index = i.getAndIncrement();
      assertThat(expressions[index]).isEqualTo(key);
      assertThat(results[index]).isEqualTo(value);


    });
  }


}