package com.devcourse.java.domain.menu;

public class MenuMapper {
    private final Query query;
    private final Calculate calculate;

    public MenuMapper(Query query, Calculate calculate) {
        this.query = query;
        this.calculate = calculate;
    }

    public Menu toMenu(MenuType menuType) {
        return switch (menuType) {
            case QUERY -> query;
            case CALCULATE -> calculate;
            default -> new Exit();
        };
    }
}
