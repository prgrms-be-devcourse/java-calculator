package creator;

import creator.type.RepositoryType;
import creator.type.ServiceType;
import repository.CalculatorRepository;
import repository.InMemoryRepository;
import service.CalculatorService;
import service.ClientService;
import service.Service;

public class CreatorManagement {

    public static Service createService(ServiceType type){
        switch (type){
            case CLIENT:
                return new ClientService();
            case CALCULATOR:
                return new CalculatorService();
            default:
                throw new IllegalArgumentException("지원하지 않는 서비스 타입");
        }

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
