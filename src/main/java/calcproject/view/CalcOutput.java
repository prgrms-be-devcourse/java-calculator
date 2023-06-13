package calcproject.view;

import java.util.List;

import calcproject.models.CalcResultRecordModel;

public interface CalcOutput {
	public void showCalcResult(CalcResultRecordModel calcResultRecordModel);

	public void showRecord(List<CalcResultRecordModel> calcResultRecordModelList);

	public void showExitMessage();

}
