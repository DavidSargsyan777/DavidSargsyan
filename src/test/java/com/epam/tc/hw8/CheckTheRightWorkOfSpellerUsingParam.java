package com.epam.tc.hw8;

import com.epam.tc.hw8.service.YandexSpellerAssertions;
import com.epam.tc.hw8.utils.WordsForCheck;
import org.testng.annotations.Test;

public class CheckTheRightWorkOfSpellerUsingParam {
    @Test
    void checkTheWordOnEnglishWithRuParam() {
        new YandexSpellerAssertions().checkTheCorrectWorkWithLangParam(WordsForCheck.WRONG_WORD_ON_ENGLISH, "ru");
    }

    @Test
    void checkTheWordOnRussianWithEnParam() {
        new YandexSpellerAssertions().checkTheCorrectWorkWithLangParam(WordsForCheck.WRONG_WORD_ON_RUSSIAN, "en");
    }

    @Test
    void checkTheWordWithParamOptionsExcludingRepeating() {
        new YandexSpellerAssertions().checkTheCorrectWorkWithOptionsParam("Hi my my name is David", "8", "my");
    }
}
