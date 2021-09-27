package com.epam.tc.hw8;

import com.epam.tc.hw8.data.DataProviderClass;
import com.epam.tc.hw8.service.YandexSpellerAssertions;
import org.testng.annotations.Test;

public class CheckListOfWords {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "A set of wrong words")
    public void checkListOfWordsOnEnglish(String actual, String expected){

        new YandexSpellerAssertions().checkTheCorrectWord(actual, expected);
    }
}
