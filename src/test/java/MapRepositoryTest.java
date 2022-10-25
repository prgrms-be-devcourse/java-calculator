import com.calculator.entity.Expression;
import com.calculator.repository.MapRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MapRepositoryTest {

    MapRepository repository = new MapRepository();

    /**
     * 조회는 테스트를 어떻게 해야하지?
     */
    @Test
    @DisplayName("repo 조회")
    void find() {
        repository.findAll();
    }

    @Test
    @DisplayName("repo 저장")
    void save() {
        Expression expression = new Expression();

        int id = repository.save(expression);

        Expression byId = repository.findById(id);

        assertThat(expression).isEqualTo(byId);
    }
}
