package view;


public class OutputView {
    public enum Menu {
        CHECK("1. 조회"),
        CALCULATE("2. 계산"),
        END("3. 종료");

        private final String description;

        Menu(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private static final String INPUT = "선택 : ";

    public static void printSelectMenu() {
        System.out.println(Menu.CHECK.getDescription());
        System.out.println(Menu.CALCULATE.getDescription());
        System.out.println(Menu.END.getDescription());
        System.out.print(INPUT);
    }

    public static void printErrorMessage(String em) {
        System.out.println(em);
    }
}
