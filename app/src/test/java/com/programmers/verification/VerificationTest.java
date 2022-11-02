package com.programmers.verification;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("검증 테스트")
public class VerificationTest {

  private final Verification verification = new Verification();

  @DisplayName("입력받은 식이 연산자로 시작할 때 false를 리턴한다.")
  @Test
  void startOper() {
    //given
    String input = "+ 2 - 3";
    //when
    boolean result = verification.verify(input);
    //then
    assertFalse(result);
  }

  @DisplayName("입력받은 식이 연산자로 끝날때 false를 리턴한다")
  @Test
  void endOper() {
    //given
    String input = "2 - 3 *";
    //when
    boolean result = verification.verify(input);
    //then
    assertFalse(result);
  }

  @DisplayName("숫자가 연속 두번이상 들어갈 때 false를 리턴한다")
  @Test
  void consecutiveNumbers() {
    //given
    String input = "2 2 - 3";
    //when
    boolean result = verification.verify(input);
    //then
    assertFalse(result);
  }

  @DisplayName("연산자가 연속 두번이상 들어갈 때 false를 리턴한다")
  @Test
  void continuationOperator() {
    //given
    String input = "2 + - 3";
    //when
    boolean result = verification.verify(input);
    //then
    assertFalse(result);
  }

  @DisplayName("입력받은 식에 영어가 들어가면 false를 리턴한다")
  @Test
  void hasEng() {
    //given
    String input = "k + 3";
    //when
    boolean result = verification.verify(input);
    //then
    assertFalse(result);
  }

  @DisplayName("입력받은 식에 한글이 들어가면 false를 리턴한다")
  @Test
  void hasKor() {
    //given
    String input = "가 + 3";
    //when
    boolean result = verification.verify(input);
    //then
    assertFalse(result);
  }

  @DisplayName("입력받은 식에 연산자가 아닌 다른 특수기호가 들어가면 false를 리턴한다")
  @Test
  void hasSpecialChar() {
    //given
    String input = "2 ( 3 ^";
    //when
    boolean result = verification.verify(input);
    //then
    assertFalse(result);
  }

}
