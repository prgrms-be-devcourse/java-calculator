public class CalculateService implements CalculatorFunction {

    String name;

    public CalculateService(String name) {
        this.name = name;
    }

    @Override
    public void doService() {
        System.out.println("CalculateService.doService");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
