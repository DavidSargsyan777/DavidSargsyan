package com.epam.tc.hw9;

import com.epam.tc.hw9.service.YandexSpellerAssertions;
import com.epam.tc.hw9.utils.WordsForCheck;
import org.testng.annotations.Test;

public class CheckTheRightWorkOfSpellerUsingParam {
    @Test
    void checkTheWordOnEnglishWithRuParam() {
        new YandexSpellerAssertions().checkTheCorrectWorkWithLangParam(WordsForCheck.WRONG_WORD_ON_ENGLISH, "ru", WordsForCheck.RIGHT_WORD_ON_ENGLISH);
    }

    @Test
    void checkTheWordOnRussianWithEnParam() {
        new YandexSpellerAssertions().checkTheCorrectWorkWithLangParam(WordsForCheck.WRONG_WORD_ON_RUSSIAN, "en", WordsForCheck.RIGHT_WORD_ON_RUSSIAN);
    }

    @Test
    void checkTheWordWithParamOptionsExcludingRepeating() {
        new YandexSpellerAssertions().checkTheCorrectWorkWithOptionsParam("Hi my my name is David", 8);
    }

    @Test
    void checkTheWordWithParamOptionsExcludingWordsWithNumbers() {
        new YandexSpellerAssertions().checkTheCorrectWorkWithOptionsParam("Let me speak", 2);
    }
}
