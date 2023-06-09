package calcproject.view;

import java.util.List;

import calcproject.models.CalcRecordModel;

public interface CalcOutput {
	public void showCalcResult(CalcRecordModel calcRecordModel);
	public void showRecord(List<CalcRecordModel> calcRecordModelList);
	public void showExitMessage();

}
