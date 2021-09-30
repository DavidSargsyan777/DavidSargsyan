package com.epam.tc.hw9.data;

import org.testng.annotations.DataProvider;

public class WordsData {

    @DataProvider(name = "A set of wrong words")
    public Object[][] wrongWords() {
        return new Object[][] {{"namse", "name"}, {"differentliy", "differently"}, {"brzidge", "bridge"},
            {"knowledje", "knowledge"}};
    }
}
