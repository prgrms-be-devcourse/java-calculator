public interface ICalculator<T extends Number> {
    default Number add(T a, T b){
        return 1;
    }
    default Number sub(T a, T b){
        return 1;
    }
    default Number mul(T a, T b){
        return 1;
    }
    default Number div(T a, T b){
        return 1;
    }
}
