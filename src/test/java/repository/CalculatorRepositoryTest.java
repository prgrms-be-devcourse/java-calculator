package repository;

import entity.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorRepositoryTest {
    CalculatorRepository cr = new CalculatorMemoryRepository();

    @BeforeEach
    void before(){
        cr.clear();
    }

    @Test
    @DisplayName("데이터 저장")
    void save() {
        Data data1 = new Data(0L, "a", "resultA");
        Data data2 = new Data(1L, "b", "resultB");
        Data data3 = new Data(2L, "c", "resultC");

        String saveResult1 = cr.save(data1);
        String saveResult2 = cr.save(data2);
        String saveResult3 = cr.save(data3);

        assertEquals(saveResult1, "resultA");
        assertEquals(saveResult2, "resultB");
        assertEquals(saveResult3, "resultC");

    }

    @Test
    @DisplayName("ID로 데이터 조회")
    void findById() {

        Data data1 = new Data(0L, "a", "resultA");
        Data data2 = new Data(1L, "b", "resultB");
        Data data3 = new Data(2L, "c", "resultC");

        cr.save(data1);
        cr.save(data2);
        cr.save(data3);

        Data findData = cr.findById(0L);

        assertEquals(data1.getId(), findData.getId());
        assertEquals(data1.getCalculationFormula(), findData.getCalculationFormula());
        assertEquals(data1.getResult(), findData.getResult());
    }

    @Test
    @DisplayName("저장 데이터 모두 조회")
    void findAll() {

        Data data1 = new Data(0L, "a", "resultA");
        Data data2 = new Data(1L, "b", "resultB");
        Data data3 = new Data(2L, "c", "resultC");


        cr.save(data1);
        cr.save(data2);
        cr.save(data3);

        List<Data> dataL = List.of(data1, data2, data3);
        List<Data> dataList = cr.findAll();

        assertEquals(dataList,dataL);
    }

    @Test
    @DisplayName("저장소 초기화")
    void clear() {
        cr.clear();
        assertTrue(cr.findAll().isEmpty());
    }
}
