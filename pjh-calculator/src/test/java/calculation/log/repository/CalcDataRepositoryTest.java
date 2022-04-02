package calculation.log.repository;

import static org.assertj.core.api.Assertions.assertThat;

import calculation.model.CalculationData;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalcDataRepositoryTest {

  DataRepository<CalculationData, Long> calcDataRepository = new CalculationDataRepository();

  @DisplayName("저장 테스트")
  @Test
  void save() {
    //given
    String expression = "1 + 2 + 3";
    BigDecimal answer = new BigDecimal(6.0);
    calcDataRepository.save(new CalculationData(expression,answer));

    //when
    Optional<CalculationData> foundData = calcDataRepository.findById(0L);

    //then
    assertThat(foundData.isPresent()).isTrue();
    assertThat(foundData.get().getExpression()).isEqualTo(expression);
    assertThat(foundData.get().getAnswer()).isEqualTo(answer);
  }

  @DisplayName("전체 조회 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "1 + 2 + 3:6",
      "1 + 2 * 3:7"
  }, delimiter = ':')
  void findAll(String expression, BigDecimal answer) {
    //given
    calcDataRepository.save(new CalculationData(expression,answer));

    //when
    List<CalculationData> foundData = calcDataRepository.findAll();

    //then
    assertThat(foundData.get(0).getExpression()).isEqualTo(expression);
    assertThat(foundData.get(0).getAnswer()).isEqualTo(answer);
  }
}