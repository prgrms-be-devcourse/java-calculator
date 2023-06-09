package calcproject.repository;

import java.util.List;

import calcproject.models.CalcRecordModel;

public interface CalcRecordRepository {
	void saveCalcRecord(CalcRecordModel calcRecord);

	List<CalcRecordModel> loadCalcRecords();
}
