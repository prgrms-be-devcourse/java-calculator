package calcproject.repository;

import java.util.List;

import calcproject.models.CalcResultRecordModel;

public interface CalcResultRecordRepository {
	void saveCalcResultRecord(CalcResultRecordModel calcResultRecord);

	List<CalcResultRecordModel> loadCalcResultRecords();
}
