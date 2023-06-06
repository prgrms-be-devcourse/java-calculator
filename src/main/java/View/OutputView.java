package View;


import Model.Memorizer;

public class OutputView {

    Memorizer memorizer = Memorizer.getInstance();

    public static void showHistory() {
        int times = history.size();

        if(times == 0) {
            System.out.println("there is no history..");
            return;
        }

        while(times > 0) {
            String result = history.poll();
            System.out.println(result);
            times--;
            history.add(result);
        }
    }

    public static void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
    }
}
