
import model.Calculator;
import model.History;
import model.Operator;

//Index에서 사용자가 입력을 하면 해당 옵션에 맞는 메소드를 제공해줍니다.
//만약 예외가 발생하면 오류 메세지를 출력
public class Console{
    //사용자가 1번(조회)를 선택하였을 시 실행
    public void getHistory(History history) {
        if(history.isEmpty()){
            System.out.println("조회된 데이터가 없습니다.");
            return;
        }

        history.getHistory();
    }
    //사용자가 2번(계산)를 선택하였을 시 실행
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
