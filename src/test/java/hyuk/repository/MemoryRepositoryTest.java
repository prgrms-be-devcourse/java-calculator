package hyuk.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hyuk.calculator.Result;
import hyuk.entity.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryRepositoryTest {

    MemoryRepository memoryRepository = new MemoryRepository();

    @BeforeEach
    void init() {
        memoryRepository.removeAll();
    }

    @DisplayName("계산이력 저장 기능 테스트")
    @Test
    void store() {
        //given
        //when
        memoryRepository.store(new Record("1 + 2 * 3 + 4", new Result(11)));

        //then
        assertThat(memoryRepository.getRecordsSize()).isEqualTo(1);
    }

    @DisplayName("여러 레코드 저장")
    @Test
    void stores() {
        //given
        //when
        memoryRepository.store(new Record("1 + 2 * 3 + 4", new Result(11)));
        memoryRepository.store(new Record("1 + 2 * 3 + 4", new Result(11)));

        //then
        assertThat(memoryRepository.getRecordsSize()).isEqualTo(2);
    }

    @DisplayName("id로 레코드 찾는 기능 테스트")
    @Test
    void testFindById() {
        //given
        //when
        Record record = new Record("1 + 2 * 3 + 4", new Result(11));
        memoryRepository.store(record);

        //then
        assertThat(memoryRepository.findById((long) 1)).isEqualTo(record);
    }

    @DisplayName("id로 레코드 찾기 test - 여러 레코드가 저장된 경우")
    @Test
    void testFindById_2() {
        //given
        //when
        memoryRepository.store(new Record("1 + 2 * 3 + 4", new Result(11)));
        Record record = new Record("1 + 2  + 3", new Result(11));
        memoryRepository.store(record);

        //then
        assertThat(memoryRepository.findById((long) 2)).isEqualTo(record);
    }

}
