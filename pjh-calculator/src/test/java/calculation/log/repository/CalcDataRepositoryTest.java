package calculation.log.repository;

import calculation.model.CalcData;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcDataRepositoryTest {

  DataRepository<CalcData, Long> calcDataRepository = new CalcDataRepository();

  @Test
  void save() {
    //given
    String expression = "1 + 2 + 3";
    BigDecimal ans = new BigDecimal(6.0);

    //when
    calcDataRepository.save(new CalcData(expression,ans));
    Optional<CalcData> findData = calcDataRepository.findById(0L);

    //then
    Assertions.assertTrue(findData.isPresent());
    Assertions.assertEquals(expression, findData.get().getExpression());
    Assertions.assertEquals(ans, findData.get().getAns());
  }

  @Test
  void findAll() {
    //given
    String expressionA = "1 + 2 + 3";
    String expressionB = "1 + 2 * 3";
    BigDecimal ansA = new BigDecimal(6.0);
    BigDecimal ansB = new BigDecimal(7.0);

    //when
    calcDataRepository.save(new CalcData(expressionA,ansA));
    calcDataRepository.save(new CalcData(expressionB,ansB));
    List<CalcData> findData = calcDataRepository.findAll();

    //then
    Assertions.assertEquals(expressionA, findData.get(0).getExpression());
    Assertions.assertEquals(expressionB, findData.get(1).getExpression());
    Assertions.assertEquals(ansA, findData.get(0).getAns());
    Assertions.assertEquals(ansB, findData.get(1).getAns());
  }
}