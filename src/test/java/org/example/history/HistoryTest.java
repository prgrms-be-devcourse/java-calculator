package org.example.history;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HistoryTest {

  History history = new History();

  @Test
  @DisplayName("계산 기록 저장 테스트")
  void save() {

    //given
    Formula formula1 = new Formula("1 + 1", 2);
    Formula formula2 = new Formula("2 + 2", 4);

    //when
    history.save(formula1);
    history.save(formula2);

    //then
    Assertions.assertThat(history.getMemory().size()).isEqualTo(2);
  }

  @Test
  @DisplayName("계산 기록 저장 실패 테스트")
  void saveFailure() {

    //given
    Formula formula1 = new Formula("1 + 1", 2);
    Formula formula2 = new Formula("2 + 2", 4);

    //when
    history.save(formula1);
    history.save(formula2);

    //then
    Assertions.assertThat(history.getMemory().size()).isEqualTo(3);
  }
}
