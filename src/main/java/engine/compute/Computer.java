package engine.compute;

public class Computer {
    private final ComputeService computeService;

    public Computer(ComputeService computeService) {
        this.computeService = computeService;
    }

    public String compute(String input) {
        return computeService.compute(input);
    }
}
