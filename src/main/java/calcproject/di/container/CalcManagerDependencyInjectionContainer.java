package calcproject.di.container;

import calcproject.engine.Calculator;
import calcproject.factory.CalcManagerViewFactory;
import calcproject.factory.CalcResultRecordRepositoryFactory;
import calcproject.repository.CalcResultRecordRepository;
import calcproject.service.CalcManager;
import calcproject.view.CalcInput;
import calcproject.view.CalcOutput;

public class CalcManagerDependencyInjectionContainer {

	private CalcResultRecordRepositoryFactory calcResultRecordRepositoryFactory;

	private CalcManagerViewFactory calcManagerViewFactory;

	private Calculator calculator;

	public CalcManagerDependencyInjectionContainer(
		CalcResultRecordRepositoryFactory calcResultRecordRepositoryFactory,
		CalcManagerViewFactory calcManagerViewFactory,
		Calculator calculator
	) {
		this.calcResultRecordRepositoryFactory = calcResultRecordRepositoryFactory;
		this.calcManagerViewFactory = calcManagerViewFactory;
		this.calculator = calculator;
	}

	public CalcManager createCalcManager() {
		CalcResultRecordRepository calcResultRecordRepository =
			calcResultRecordRepositoryFactory.createCalcResultRecordRepository();

		CalcInput calcInput =
			calcManagerViewFactory.createCalcInput();

		CalcOutput calcOutput =
			calcManagerViewFactory.createCalcOutput();

		CalcManager calcManager = new CalcManager(
			calcResultRecordRepository,
			calcInput,
			calcOutput,
			this.calculator
		);

		return calcManager;
	}
}
