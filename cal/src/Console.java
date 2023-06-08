
import model.Calculator;
import model.History;
import model.Operator;

public class Console{
    public void getHistory(History history) {
        if(history.isEmpty()){
            System.out.println("조회된 데이터가 없습니다.");
            return;
        }

        history.getHistory();
    }

    public Integer input(String inputString, Calculator calculator, Operator operator,History history){
        if(inputString.equals("")) {
            System.out.println("식을 입력해주세요");
            return 0;
        }

        int result = calculator.cal(inputString,operator,history);

        System.out.println(result);

        return result;
    }
}
