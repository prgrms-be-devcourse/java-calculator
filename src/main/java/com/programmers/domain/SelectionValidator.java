package com.programmers.domain;

import com.programmers.exception.SelectionEmptyException;
import com.programmers.exception.SelectionFormatException;

public class SelectionValidator {

    public void validate(String selection) {
        isEmpty(selection);
        isNotMenuNumber(selection);
    }

    public void isEmpty(String selection) {
        if (selection.isEmpty()) {
            throw new SelectionEmptyException();
        }
    }

    public void isNotMenuNumber(String selection) {
        try {
            Integer.parseInt(selection);
        } catch (NumberFormatException e) {
            throw new SelectionFormatException();
        }

        if (!selection.equals("1") && !selection.equals("2") && !selection.equals("3")) {
            throw new SelectionFormatException();
        }
    }
}