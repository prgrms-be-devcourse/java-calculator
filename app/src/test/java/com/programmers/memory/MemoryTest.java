package com.programmers.memory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MemoryClass 테스트")
public class MemoryTest {

  private Memory memory;

  @BeforeEach
  void setUp() {
    memory = new Memory();
  }

  @DisplayName("메모리 내역 조회시 내역이 없을 때 Exception을 던진다.")
  @Test
  void ifMemoryIsEmpty() {
    //given
    memory = new Memory();
    //when & then
    assertThrows(NoSuchElementException.class, () -> memory.findAll(), "저장된 내역이 없습니다");
  }

  @DisplayName("메모리 내역 조회시 내역이 있을 때 전체 내역을 리턴한다.")
  @Test
  void getMemoryList() {
    //given
    memory.save("2 + 3 = 5");
    memory.save("10 + 3 = 13");

    List<String> expect = new ArrayList<>(List.of("2 + 3 = 5", "10 + 3 = 13"));
    //when
    List<String> result = memory.findAll();
    //then
    assertEquals(expect, result);
  }


}
