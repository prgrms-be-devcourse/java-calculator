package hyuk.repository;

import static org.assertj.core.api.Assertions.assertThat;

import hyuk.entity.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MemoryRepositoryTest {

    MemoryRepository memoryRepository = new MemoryRepository();

    @Mock
    Log log;

    @DisplayName("계산이력 저장 기능 테스트")
    @Test
    void store() {
        //given
        //when
        memoryRepository.store(log);

        //then
        assertThat(memoryRepository.getData().size())
            .isEqualTo(1);
    }

}
