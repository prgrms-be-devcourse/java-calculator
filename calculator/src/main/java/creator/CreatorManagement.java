package creator;

import creator.type.RepositoryType;
import repository.CalculatorRepository;
import repository.InMemoryRepository;
import service.CalculatorService;
import service.ClientService;

/**
 * 1. 구조에 대한 문제.
 * 정적 메서드를 이용해서 인스턴스를 생성하는 책임을 갖게하고 싶었는데
 * 공부를 하면 할 수록 정적메서드를 사용하는 것이 올바른 것인지...
 *
 * 이 매니지먼트가 너무 각기 다른 역할을 하는 많은 인스턴스를 생성하는 것같음
 * 3.27
 */
public class CreatorManagement {

    public static ClientService getClientService(){
        return new ClientService();
    }

    public static CalculatorService getCalcService(){
        return new CalculatorService();
    }

    public static CalculatorRepository createCalculatorRepository(RepositoryType type){

        switch (type){
            case InMemory:
                return new InMemoryRepository();
            default:
                throw new IllegalArgumentException("지원하지 않는 저장소 타입");
        }
    }
}
