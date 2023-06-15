package calcproject.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import calcproject.models.CalcResultRecordModel;

public class MemoryCalcResultRecordRepository implements CalcResultRecordRepository {

	private Map<Integer, CalcResultRecordModel> calcMap;
	private int lastIdx;

	public MemoryCalcResultRecordRepository(Map<Integer, CalcResultRecordModel> calcMap, int startIdx) {
		this.calcMap = calcMap;
		this.lastIdx = startIdx;
	}

	@Override
	public void saveCalcResultRecord(CalcResultRecordModel calcResultRecord) {
		this.calcMap.put(this.lastIdx, calcResultRecord);
		this.lastIdx += 1;
	}

	@Override
	public List<CalcResultRecordModel> loadCalcResultRecords() {
		return this.calcMap.values()
			.stream()
			.sorted(Comparator.comparing(CalcResultRecordModel::getId))
			.collect(Collectors.toList());
	}
}
