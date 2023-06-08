package calculator.view;

public class OutputView {

    private OutputView() {
    }

    public static void printWithLineBreak() {
        System.out.println();
    }

    public static void printWithLineBreak(String output) {
        System.out.println(output);
    }

    public static void printWithoutLineBreak(String output) {
        System.out.print(output);
    }

    public static <T> void printMultiple(T[] outputs) {
        for (T output : outputs) {
            System.out.println(output);
        }
    }
}
