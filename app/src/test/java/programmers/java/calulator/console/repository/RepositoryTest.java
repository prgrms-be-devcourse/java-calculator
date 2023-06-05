package programmers.java.calulator.console.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryTest {
    private MapRepository repository;

    @BeforeEach
    public void setUp() {
        repository = MapRepository.getInstance();
    }

    @Test
    @DisplayName("연산 기록이 잘되는지 확인하는 테스트")
    public void add_기능이_잘되는지_확인하기() {
        // Given
        String expression = "2+2";
        int result = 4;

        // When
        repository.add(expression, result);

        // Then
        assertTrue(repository.getRepository().containsKey(expression));
        assertEquals(repository.getRepository().get(expression), result);
    }

    @Test
    @DisplayName("계산을 기록하는 repository가 싱글톤으로 관리되는지 확인하는 테스트")
    public void 싱글톤_리포지토리_테스트() {
        // Given
        // Initialization done in setUp

        // When
        MapRepository firstInstance = MapRepository.getInstance();
        MapRepository secondInstance = MapRepository.getInstance();

        // Then
        assertEquals(firstInstance, secondInstance);
    }
}

