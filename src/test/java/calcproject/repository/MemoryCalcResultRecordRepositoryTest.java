package calcproject.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calcproject.models.CalcResultRecordModel;

class MemoryCalcResultRecordRepositoryTest {

	private CalcResultRecordRepository calcResultRecordRepository;

	@BeforeEach
	void beforeEach() {
		Map<Integer, CalcResultRecordModel> calcMap = new HashMap<>();
		int startIdx = 0;
		this.calcResultRecordRepository =
			new MemoryCalcResultRecordRepository(calcMap, startIdx);
	}

	@Test
	void testLoadCalcRecords() {
		// given
		CalcResultRecordModel calcRecord1 = new CalcResultRecordModel("2+2", 4);
		CalcResultRecordModel calcRecord2 = new CalcResultRecordModel("3+3", 6);
		calcResultRecordRepository.saveCalcResultRecord(calcRecord1);
		calcResultRecordRepository.saveCalcResultRecord(calcRecord2);
		List<CalcResultRecordModel> expectedCalcRecords = Arrays.asList(calcRecord1, calcRecord2);

		// when
		List<CalcResultRecordModel> resultCalcRecords = calcResultRecordRepository.loadCalcResultRecords();

		// then
		Assertions.assertThat(resultCalcRecords)
			.containsExactlyInAnyOrderElementsOf(expectedCalcRecords);
	}
}