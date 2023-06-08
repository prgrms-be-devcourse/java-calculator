package calcproject.service;

import calcproject.models.CalcModel;
import calcproject.repository.CalcModelRepository;

import java.util.Collection;
import java.util.List;

public class CalcManager {
    private CalcModelRepository calcModelRepository;

    public CalcManager(CalcModelRepository calcModelRepository) {
        this.calcModelRepository = calcModelRepository;
    }

    public void printHistory() {
        Collection<CalcModel> calcModels = calcModelRepository.LoadCalcModels();
        for(CalcModel calcModel : calcModels){
            System.out.println(calcModel);
        }
    }

    public double calculateExpressionAndSave(String expression) {
        List<TokenItem> tokens = CalcExpressionTokenizer.tokenizeExpression(expression);
        double r = Calculator.calculateToken(tokens);
        calcModelRepository.SaveCalcModel(new CalcModel(expression, r));

        return r;
    }
}