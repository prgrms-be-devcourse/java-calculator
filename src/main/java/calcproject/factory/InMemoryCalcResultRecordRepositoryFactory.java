package calcproject.factory;

import java.util.HashMap;
import java.util.Map;

import calcproject.models.CalcResultRecordModel;
import calcproject.repository.CalcResultRecordRepository;
import calcproject.repository.MemoryCalcResultRecordRepository;

public class InMemoryCalcResultRecordRepositoryFactory implements CalcResultRecordRepositoryFactory {

	@Override
	public CalcResultRecordRepository createCalcResultRecordRepository() {
		Map<Integer, CalcResultRecordModel> calcMap = new HashMap<>();
		CalcResultRecordRepository calcResultRecordRepository =
			new MemoryCalcResultRecordRepository(calcMap);

		return calcResultRecordRepository;
	}
}
