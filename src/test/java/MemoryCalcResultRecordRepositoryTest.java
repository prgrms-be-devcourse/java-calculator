package calcproject.repository;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calcproject.models.CalcResultRecordModel;

class MemoryCalcResultRecordRepositoryTest {

	private CalcResultRecordRepository calcResultRecordRepository;

	@BeforeEach
	void onlyonce() {
		this.calcResultRecordRepository = new MemoryCalcResultRecordRepository();
	}

	@Test
	void testLoadCalcRecords() {
		// given
		CalcResultRecordModel calcRecord1 = new CalcResultRecordModel("2+2", 4);
		CalcResultRecordModel calcRecord2 = new CalcResultRecordModel("3+3", 6);
		calcResultRecordRepository.saveCalcResultRecord(calcRecord1);
		calcResultRecordRepository.saveCalcResultRecord(calcRecord2);

		// when
		List<CalcResultRecordModel> resultCalcRecords = calcResultRecordRepository.loadCalcResultRecords();
		List<CalcResultRecordModel> expectedCalcRecords = Arrays.asList(calcRecord1, calcRecord2);

		// then
		Assertions.assertThat(resultCalcRecords)
			.containsExactlyInAnyOrderElementsOf(expectedCalcRecords);
	}
}