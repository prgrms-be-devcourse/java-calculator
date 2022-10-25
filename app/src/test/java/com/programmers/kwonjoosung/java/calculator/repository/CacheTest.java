package com.programmers.kwonjoosung.java.calculator.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {
    static Cache cache;
    @Test
    @DisplayName("캐시 동작 테스트") // 캐시에 값과 결과를 추가한 후에 값 받아오기
    void cacheTest(){
        //given
        cache = new HashMapCache();
        String[] expression = new String[]{"12","+","12"};
        String result = "24";
        cache.add(expression,result);
        assertEquals(result, cache.getResult(expression).get());
    }
}
