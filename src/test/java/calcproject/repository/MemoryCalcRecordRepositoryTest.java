package calcproject.repository;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calcproject.models.CalcRecordModel;

class MemoryCalcRecordRepositoryTest {

	private CalcRecordRepository calcRecordRepository;

	@BeforeEach
	void onlyonce() {
		this.calcRecordRepository = new MemoryCalcRecordRepository();
	}

	@Test
	void testLoadCalcRecords() {
		// given
		CalcRecordModel calcRecord1 = new CalcRecordModel("2+2", 4);
		CalcRecordModel calcRecord2 = new CalcRecordModel("3+3", 6);
		calcRecordRepository.saveCalcRecord(calcRecord1);
		calcRecordRepository.saveCalcRecord(calcRecord2);

		// when
		var resultCalcRecords = calcRecordRepository.loadCalcRecords();
		var expectedCalcRecords = Arrays.asList(calcRecord1, calcRecord2);

		// then
		Assertions.assertThat(resultCalcRecords)
			.containsExactlyInAnyOrderElementsOf(expectedCalcRecords);
	}
}