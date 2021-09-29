package com.epam.tc.hw9;

import com.epam.tc.hw9.data.DataStore;
import com.epam.tc.hw9.service.YandexSpellerAssertions;
import org.testng.annotations.Test;

public class CheckTextListOfWords {
    @Test(dataProviderClass = DataStore.class, dataProvider = "A set of wrong words")
    public void checkTextListOfWordsOnEnglish(String actual, String expected) {
        new YandexSpellerAssertions().checkText(actual, expected);
    }
}
