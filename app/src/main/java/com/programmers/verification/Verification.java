package com.programmers.verification;

import java.util.List;

public interface Verification {

  boolean verifyInput(List<String> form);

  boolean checkOperPosition(List<String> form);

  boolean checkLang(List<String> form);

  boolean checkStartAndEndWithOper(List<String> form);
}
