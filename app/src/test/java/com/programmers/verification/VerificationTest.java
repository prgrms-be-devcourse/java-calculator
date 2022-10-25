package com.programmers.verification;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VerificationTest {
  Verification verification = new VerificationImpl();

  @Test
  @DisplayName("연산자가 제대로 위치해 있는지 테스트")
  void checkOperPosition() {
    //given
    String input = "2 + 3 - 4";
    List<String> form = new ArrayList<>(List.of(input.split(" ")));
    //when
    boolean check = verification.checkOperPosition(form);
    //then
    assertTrue(check);
  }

  @Test
  @DisplayName("입력 받은 식에 한글 또는 영어 존재여부 테스트")
  void checkLang() {
    //given
    String input = "a + 가 - 4";
    List<String> form = new ArrayList<>(List.of(input.split(" ")));
    //when
    boolean check = verification.checkLang(form);
    //then
    assertTrue(check);
  }

  @Test
  @DisplayName("입력받은 식의 첫번째와 마지막에 연산자 존재여부 테스트")
  void checkStartAndEndWithOper() {
    //given
    String input = "+ 2 - 3 *";
    List<String> form = new ArrayList<>(List.of(input.split(" ")));
    //when
    boolean check = verification.checkStartAndEndWithOper(form);
    //then
    assertTrue(check);
  }

}
