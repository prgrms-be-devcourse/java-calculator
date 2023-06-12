package programmers.java.calulator.console.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.java.calulator.common.repository.History;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapRepositoryTest {
    private final MapRepository repository = MapRepository.getInstance();

    @Test
    @DisplayName("100개의 스레드에서 동시에 저장을 시도했을 때 저장이 안정적으로 되는지 확인하는 테스트")
    public void save_동시성_테스트() throws InterruptedException {
        // Given
        int numThreads = 100;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        String expression = "2 + 2";
        int result = 4;

        // When
        IntStream.rangeClosed(1, numThreads)
                .forEach(i -> executor.execute(() -> {
                    History history = new MapHistory(expression + " * " + i, result * i);
                    repository.save(history);
                }));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Then
        assertEquals(numThreads, repository.findAll().size());
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
