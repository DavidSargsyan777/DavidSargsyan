package com.epam.tc.hw9;

import static com.epam.tc.hw9.utils.Languages.ENGLISH;
import static com.epam.tc.hw9.utils.Languages.RUSSIAN;
import static com.epam.tc.hw9.utils.WordsForCheck.REPEATING_WORD;
import static com.epam.tc.hw9.utils.WordsForCheck.RIGHT_WORD_ON_ENGLISH;
import static com.epam.tc.hw9.utils.WordsForCheck.RIGHT_WORD_ON_RUSSIAN;
import static com.epam.tc.hw9.utils.WordsForCheck.WORD_WITH_DIGITS;
import static com.epam.tc.hw9.utils.WordsForCheck.WRONG_WORD_ON_ENGLISH;
import static com.epam.tc.hw9.utils.WordsForCheck.WRONG_WORD_ON_RUSSIAN;

import com.epam.tc.hw9.service.YandexSpellerAssertions;
import org.testng.annotations.Test;

public class CheckTextUsingParam {
    @Test
    void checkTextOnEnglishWithRuParam() {
        new YandexSpellerAssertions().checkTextWithLangParam(WRONG_WORD_ON_ENGLISH,
            RUSSIAN, RIGHT_WORD_ON_ENGLISH);
    }

    @Test
    void checkTextOnRussianWithEnParam() {
        new YandexSpellerAssertions().checkTextWithLangParam(WRONG_WORD_ON_RUSSIAN,
            ENGLISH, RIGHT_WORD_ON_RUSSIAN);
    }

    @Test
    void checkTextWithOptionsExcludeRepeating() {
        new YandexSpellerAssertions().checkTextWithOptionsThatFindRepeatWord(REPEATING_WORD);
    }

    @Test
    void checkTextWithOptionsExcludeWordsWithNumbers() {
        new YandexSpellerAssertions().checkTextWithOptionsThatIgnoreDigits(WORD_WITH_DIGITS);
    }
}
