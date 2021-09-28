package com.epam.tc.hw9;

import com.epam.tc.hw9.data.DataProviderClass;
import com.epam.tc.hw9.service.YandexSpellerAssertions;
import org.testng.annotations.Test;

public class CheckListOfWords {
    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "A set of wrong words")
    public void checkListOfWordsOnEnglish(String actual, String expected){

        new YandexSpellerAssertions().checkTheCorrectWord(actual, expected);
    }
}
