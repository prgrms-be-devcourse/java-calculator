package hyuk.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hyuk.calculator.Result;
import hyuk.entity.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
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
        memoryRepository.store(Record.createRecord("1 + 2 * 3 + 4", new Result(11)));

        //then
        assertThat(memoryRepository.getRecordsSize()).isEqualTo(1);
    }

    @DisplayName("id로 레코드 찾는 기능 테스트")
    @Test
    void testFindById() {
        //given
        //when
        memoryRepository.store(Record.createRecord("1 + 2 * 3 + 4", new Result(11)));

        //then
        Record record = memoryRepository.findById((long) 1);
        assertThat(record).isEqualTo(record);
    }

}
