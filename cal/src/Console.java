import model.Calculator;
import model.History;
import model.Operator;

public class Console {


    public void getHistory(History history) {
        if(history.isEmpty()){

        }
        history.getHistory();
    }

    public void input(String inputString, Calculator calculator, Operator operator) {
        if(inputString.equals("")) {
            System.out.println("식을 입력해주세요");
        }

        calculator.cal(inputString,operator);
    }
}
