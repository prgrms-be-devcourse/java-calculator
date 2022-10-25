package com.programmers.verification;

import com.programmers.calculation.operation.Operation;
import java.util.List;

public class VerificationImpl implements Verification {

  public boolean verifyInput(List<String> form) {

    return checkStartAndEndWithOper(form)
        || !checkOperPosition(form)
        || form.isEmpty()
        || checkLang(form);
  }

  public boolean checkOperPosition(List<String> form) {
    for (int i = 0; i < form.size(); i++) {
      if (i % 2 == 1) {
        return Operation.find(form.get(i));
      }
    }
    return false;
  }

  public boolean checkLang(List<String> form) {
    for (String s : form) {
      if (s.matches("^[a-zA-Zㄱ-ㅎ가-힣]*$")) {
        return true;
      }
    }
    return false;
  }

  public boolean checkStartAndEndWithOper(List<String> form) {
    return (Operation.find(form.get(0)) || Operation.find(form.get(form.size() - 1)));
  }

}

