package calcproject;

import calcproject.di.container.CalcManagerDependencyInjectionContainer;
import calcproject.factory.CalcManagerViewFactory;
import calcproject.factory.CalcResultRecordRepositoryFactory;
import calcproject.factory.ConsoleViewCalcManagerViewFactory;
import calcproject.factory.InMemoryCalcResultRecordRepositoryFacotry;
import calcproject.engine.CalcExpressionTokenizer;
import calcproject.engine.Calculator;
import calcproject.service.CalcManager;

public class Main {
	public static void main(String[] args) {
		CalcExpressionTokenizer calcExpressionTokenizer = new CalcExpressionTokenizer();
		Calculator calculator = new Calculator(calcExpressionTokenizer);

		CalcManagerViewFactory calcManagerViewFactory = new ConsoleViewCalcManagerViewFactory();
		CalcResultRecordRepositoryFactory calcResultRecordRepositoryFactory = new InMemoryCalcResultRecordRepositoryFacotry();

		CalcManagerDependencyInjectionContainer calcManagerDependencyInjectionContainer =
			new CalcManagerDependencyInjectionContainer(calcResultRecordRepositoryFactory, calcManagerViewFactory, calculator);

		CalcManager calcManager = calcManagerDependencyInjectionContainer.createCalcManager();
		calcManager.startCalcManager();
	}
}
