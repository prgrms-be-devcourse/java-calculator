package org.programmers.calculator.repository;

import java.util.List;

/**
 * 계산 결과를 저장, 탐색하는 역할을 담당한다.
 * @ImplNote
 * 탐색 결과가 실패일 경우(null이나, 여러 문제가 발생했을 경우) 구현 클래스에서 오류 메시지를 String 형태로 생성, 리턴해야 한다.
 */
public interface Repository {

    void save(String expression, String result);
    String findPrevious();
    String findByKey(String expression);
    List<String> printAll();
}
