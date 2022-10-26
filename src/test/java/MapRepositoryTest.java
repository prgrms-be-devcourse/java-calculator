import com.calculator.entity.Expression;
import com.calculator.repository.MapRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MapRepositoryTest {

    MapRepository repository = new MapRepository();

    @Test
    @DisplayName("repo 조회")
    void find() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Expression expression = new Expression("(2 + 4) / (6 - 3)", 2);

        repository.save(expression);
        repository.findAll();

        assertThat(out.toString()).isEqualTo("(2 + 4) / (6 - 3) = 2\n");
    }

    @Test
    @DisplayName("save(), findByInfix(): map에 계산식이 존재하는 경우")
    void save() {
        Expression expression = new Expression("(2 + 4) / (6 - 3)", 2);

        repository.save(expression);

        Expression byInfix = repository.findByInfix("(2 + 4) / (6 - 3)");

        assertThat(expression.equals(byInfix)).isTrue();
    }

    @Test
    @DisplayName("findByInfix(): map에 일치하는 계산식이 없음")
    void x() {
        Expression byInfix = repository.findByInfix("1 + 2");

        assertThat(byInfix).isNull();
    }
}
