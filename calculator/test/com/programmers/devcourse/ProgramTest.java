package com.programmers.devcourse;

import org.junit.jupiter.api.Test;

class ProgramTest {


  @Test
  void main() {
    assert Program.calculate("1 + 2 * 4 + 2") == 11;
    assert Program.calculate("2 * 4 + 4 / 2 + 1") == 11;
  }
}