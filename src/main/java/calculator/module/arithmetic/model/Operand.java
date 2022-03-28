package calculator.module.arithmetic.model;

public class Operand {
    private Double value;
    public static boolean isOperand(String target){
        double numeric;
        try{
            numeric = Double.parseDouble(target);
            return !Double.isNaN(numeric);
        }catch (NumberFormatException e){
            return false;
        }
    }
}
