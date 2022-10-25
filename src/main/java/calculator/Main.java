package calculator;

import calculator.console.Viewer;
import calculator.console.ConsoleViewer;
import calculator.repository.CalculateRepository;
import calculator.repository.MapCalculateRepository;
import calculator.service.CalculateService;
import calculator.service.BackwardCalculateService;

//의존성 주입과 클라이언트 코드 실행
public class Main {
    public static void main(String[] args) {
        CalculateRepository calculateRepository = new MapCalculateRepository();
        CalculateService calculateService = new BackwardCalculateService(calculateRepository);

        Viewer viewer = new ConsoleViewer(calculateService);

        viewer.run();
    }
}
