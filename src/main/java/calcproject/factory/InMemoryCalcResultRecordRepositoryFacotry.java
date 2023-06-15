package calcproject.factory;

import java.util.HashMap;
import java.util.Map;

import calcproject.models.CalcResultRecordModel;
import calcproject.repository.CalcResultRecordRepository;
import calcproject.repository.MemoryCalcResultRecordRepository;

public class InMemoryCalcResultRecordRepositoryFacotry implements CalcResultRecordRepositoryFactory {
	@Override
	public CalcResultRecordRepository createCalcResultRecordRepository() {
		Map<Integer, CalcResultRecordModel> calcMap = new HashMap<>();
		int startIdx = 0;
		CalcResultRecordRepository calcResultRecordRepository =
			new MemoryCalcResultRecordRepository(calcMap, startIdx);

		return calcResultRecordRepository;
	}
}
