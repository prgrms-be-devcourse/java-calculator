//package org.programmers.repository;
//
////import org.junit.jupiter.api.Assertions;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.assertj.core.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import org.programmers.entity.ResultModel;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CalculatorRepositoryTest {
//
//    private Repository repository = new CalculatorRepository();
//    Map<Long, ResultModel> map = new ConcurrentHashMap<>();
//
//    @AfterEach
//    public void afterEach(){
//        map.clear();
//    }
//
//    @Test
//    void saveAndfindAllTest() {;
//        Long id = 0L;
//
//
//        repository.save("2 * 3", 2 * 3);
//        repository.save("3 / 2", 3 / 2);
//        repository.save("4 * 2", 4 * 2);
//
//        map = repository.findAll();
//
//        Assertions.assertThat(map.size()).isEqualTo(3);
//    }
//
//
//}