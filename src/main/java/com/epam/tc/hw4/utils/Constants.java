package com.epam.tc.hw4.utils;

import java.util.Locale;

public enum Constants {
    EPAM_URL("https://jdi-testing.github.io/jdi-light/index.html"),
    DIFFERENT_ELEMENTS_URL("https://jdi-testing.github.io/jdi-light/different-elements.html"),
    HOME_PAGE("Home Page"),
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENT_PACKS("Elements packs"),
    ITEM_WIND("Wind"),
    ITEM_WATER("Water"),
    ITEM_SELEN("Selen"),
    YELLOW_COLOR("Yellow");

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
