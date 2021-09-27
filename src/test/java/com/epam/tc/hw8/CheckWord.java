package com.epam.tc.hw8;

import com.epam.tc.hw8.service.YandexSpellerAssertions;

import com.epam.tc.hw8.utils.WordsForCheck;
import org.testng.annotations.Test;

public class CheckWord {

    @Test
    void checkTheWordOnEnglish() {

        new YandexSpellerAssertions().getStatus(WordsForCheck.WRONG_WORD_ON_ENGLISH)
                                     .checkTheCorrectWord(WordsForCheck.WRONG_WORD_ON_ENGLISH,
                                         WordsForCheck.RIGHT_WORD_ON_ENGLISH);
    }

    @Test
    void checkTheWordOnRussian() {
        new YandexSpellerAssertions().checkTheCorrectWord(WordsForCheck.WRONG_WORD_ON_RUSSIAN,
            WordsForCheck.RIGHT_WORD_ON_RUSSIAN);
    }
}
