package com.epam.tc.hw5.utils;

import java.util.Locale;

public enum Constants {
    DIFFERENT_ELEMENTS_URL("https://jdi-testing.github.io/jdi-light/different-elements.html"),
    USER_TABLE_URL("https://jdi-testing.github.io/jdi-light/user-table.html"),
    ITEM_WIND("Wind"),
    ITEM_WATER("Water"),
    ITEM_SELEN("Selen"),
    YELLOW_COLOR("Yellow"),
    VIP("Vip");

    private final String constant;

    Constants(String s) {
        this.constant = s;
    }

    public String getConstant() {
        return constant;
    }

    @Override
    public String toString() {
        return constant.toUpperCase(Locale.ROOT);
    }
}
