package calculator.domain.model;

public class Message {

    private Message() {
    }

    public static void menuMessage() {
        StringBuilder menu = new StringBuilder();

        menu.append("1. 조회").append("\n");
        menu.append("2. 계산").append("\n");
        menu.append("3. 종료").append("\n");
        menu.append("\n").append("입력 : ");

        System.out.print(menu);
    }

    public static void exitMessage() {

        System.out.print("\n계산기를 종료합니다.");
    }

    public static void calculationResultMessage(HistoryModel historyModel) {

        System.out.println(historyModel.getFormula() + " = " + historyModel.getAnswer());
    }
}
