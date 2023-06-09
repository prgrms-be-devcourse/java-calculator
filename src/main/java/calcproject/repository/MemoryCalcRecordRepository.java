package calcproject.repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import calcproject.models.CalcRecordModel;

public class MemoryCalcRecordRepository implements CalcRecordRepository {

	private Map<Integer, CalcRecordModel> calcMap;
	private int lastIdx;

	public MemoryCalcRecordRepository() {
		this.calcMap = new HashMap<>();
		this.lastIdx = 0;
	}

	@Override
	public void saveCalcRecord(CalcRecordModel calcRecord) {
		this.calcMap.put(this.lastIdx, calcRecord);
		this.lastIdx += 1;
	}

	@Override
	public List<CalcRecordModel> loadCalcRecords() {
		return this.calcMap.values()
			.stream()
			.sorted(Comparator.comparing(calcModel -> calcModel.getId()))
			.collect(Collectors.toList());
	}
}
