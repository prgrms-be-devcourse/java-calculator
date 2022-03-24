package creator;

import creator.type.RepositoryType;
import repository.CalculatorRepository;
import repository.InMemoryRepository;
import service.CalculatorService;
import service.ClientService;

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
