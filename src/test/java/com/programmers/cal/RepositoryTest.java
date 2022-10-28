package com.programmers.cal;

import com.programmers.cal.engine.repository.RecordRepository;
import com.programmers.cal.engine.repository.Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTest {

//    Repository repository = new RecordRepository();
//
//    @Test
//    @DisplayName("기록 저장 성공")
//    public void successRecord() {
//        //given
//        Map<String, String> map = new LinkedHashMap<>();
//
//        String expression1 = "12+34+45";
//        String expression2 = "1 2+ -34* 2";
//        String expression3 = "-12+-34+-45";
//
//        String result1 = "91.0";
//        String result2 = "-56.0";
//        String result3 = "-91.0";
//
//        map.put(expression1, result1);
//        map.put(expression2, result2);
//        map.put(expression3, result3);
//
//        List<String> expected = Arrays.asList("12+34+45=91.0", "1 2+ -34* 2=-56.0", "-12+-34+-45=-91.0");
//
//        //when
//        repository.save(expression1, result1);
//        repository.save(expression2, result2);
//        repository.save(expression3, result3);
//
//        List<String> result = repository.findAll();
//
//        //then
//        assertThat(result).isEqualTo(expected);
//    }
}
