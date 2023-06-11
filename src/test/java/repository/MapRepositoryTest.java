package repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapRepositoryTest {

    private final MapRepository repository = new MapRepository();

    @Test
    @DisplayName("값 저장 및 출력 테스트")
    void saveInRepositoryTest() {
        assertThat(repository.getCount()).isEqualTo(0);
        repository.save("1+2");
        repository.save("1*3");
        repository.save("3+(4*8)");
        assertThat(repository.getCount()).isEqualTo(3);
    }
}