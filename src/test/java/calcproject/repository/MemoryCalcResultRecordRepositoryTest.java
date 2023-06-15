package calcproject.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import calcproject.models.CalcResultRecordModel;

class MemoryCalcResultRecordRepositoryTest {

	private CalcResultRecordRepository calcResultRecordRepository;

	@BeforeEach
	void beforeEach() {
		Map<Integer, CalcResultRecordModel> calcMap = new HashMap<>();
		int startIdx = 0;
		this.calcResultRecordRepository =
			new MemoryCalcResultRecordRepository(calcMap);
	}

	@ParameterizedTest
	@DisplayName("인 메모리 repository에 저장, 불러오기 테스트")
	@MethodSource("testLoadCalcRecordsProvider")
	void testLoadCalcRecords(List<String> expressionList, List<Double> calcResultList) {
		// given
		List<CalcResultRecordModel> expectedCalcRecords = new ArrayList<>();
		for (int i=0; i<expressionList.size(); i++) {
			String expression = expressionList.get(i);
			Double calcRsult = calcResultList.get(i);

			CalcResultRecordModel calcResultRecord = new CalcResultRecordModel(expression, calcRsult);
			this.calcResultRecordRepository.saveCalcResultRecord(calcResultRecord);
			expectedCalcRecords.add(calcResultRecord);
		}

		// when
		List<CalcResultRecordModel> resultCalcRecords = this.calcResultRecordRepository.loadCalcResultRecords();

		// then
		Assertions.assertThat(resultCalcRecords)
			.containsExactlyInAnyOrderElementsOf(expectedCalcRecords);
	}

	private static Stream<Arguments> testLoadCalcRecordsProvider() {
		return Stream.of(
			Arguments.of(Arrays.asList("1*2", "5+5-4", "1+4"), Arrays.asList(2.0, 6.0, 5.0)),
			Arguments.of(Arrays.asList("4+5+3", "5-3", "6+4"), Arrays.asList(12.0, 2.0, 10.0)),
			Arguments.of(Arrays.asList("4/2", "8+3", "7-4"), Arrays.asList(2.0, 11.0, 3.0))
		);
	}
}