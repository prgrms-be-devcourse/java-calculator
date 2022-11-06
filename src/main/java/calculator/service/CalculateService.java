package calculator.service;

import calculator.dto.Calculation;
import java.util.List;

//계산과 이력 조회 등 핵심 비즈니스를 담당하는 interface
public interface CalculateService {

    void save(Calculation calculation);

    List<Calculation> history();

    //원래 생각은 double형도 다 받아들일 수 있는 클래스를 유연하게 추가 구현하고 싶었는데
    //반환형을 Number로 설정하는 것 말고는 좋은 방법을 찾지 못하였습니다.
    int calculate(String equation);
}
