package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Factory;

public class MenuFactory implements Factory<Menu, Menus> {
    private final Query query;
    private final Calculate calculate;

    public MenuFactory(Query query, Calculate calculate) {
        this.query = query;
        this.calculate = calculate;
    }

    @Override
    public Menu create(Menus menus) {
        switch (menus) {
            case QUERY:
                return query;
            case CALCULATE:
                return calculate;
            default:
                return new Exit();
        }
    }
}
