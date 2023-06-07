package calulator.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ExpressionRepositoryTest {

    @DisplayName("계산식과 결과의 순서가 보장되어 결과 메시지를 반환한다.")
    @Test
    void resultToList(){
        ExpressionRepository repository = new InMemoryExpressionRepository();

        repository.addExpressionAndResult("1+2+3+4", "10");
        repository.addExpressionAndResult("1+2+3+4+5", "15");

        List<String> results = repository.resultsToList();

        assertThat(results).isEqualTo(List.of("1+2+3+4 = 10", "1+2+3+4+5 = 15"));
     }

}
