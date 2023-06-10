package com.devcourse.java.domain.factory;

import com.devcourse.java.domain.menu.Calculate;
import com.devcourse.java.domain.menu.Exit;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.Menus;
import com.devcourse.java.domain.menu.Query;

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
