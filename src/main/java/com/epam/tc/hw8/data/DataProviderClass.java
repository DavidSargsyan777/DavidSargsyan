package com.epam.tc.hw8.data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "A set of wrong words")
    public Object[][] allData() {
        return new Object[][] {{"namse", "name"}, {"differentliy", "differently"}, {"brzidge", "bridge"},
            {"knowledje", "knowledge"}};
    }
}
