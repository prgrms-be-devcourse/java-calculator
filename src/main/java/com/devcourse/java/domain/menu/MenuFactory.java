package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Factory;
import com.devcourse.java.domain.menu.implementation.Calculate;
import com.devcourse.java.domain.menu.implementation.Exit;
import com.devcourse.java.domain.menu.implementation.Query;

public class MenuFactory implements Factory<Menu, Menus> {

    @Override
    public Menu create(Menus menus) {
        switch (menus) {
            case QUERY:
                return Query.getInstance();
            case CALCULATE:
                return Calculate.getInstance();
            default:
                return new Exit();
        }
    }
}
