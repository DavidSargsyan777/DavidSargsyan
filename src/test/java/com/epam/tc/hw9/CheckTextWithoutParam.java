package com.epam.tc.hw9;

import static com.epam.tc.hw9.utils.WordsForCheck.RIGHT_WORD_ON_ENGLISH;
import static com.epam.tc.hw9.utils.WordsForCheck.RIGHT_WORD_ON_RUSSIAN;
import static com.epam.tc.hw9.utils.WordsForCheck.WRONG_WORD_ON_ENGLISH;
import static com.epam.tc.hw9.utils.WordsForCheck.WRONG_WORD_ON_RUSSIAN;

import com.epam.tc.hw9.service.YandexSpellerAssertions;
import org.testng.annotations.Test;

public class CheckTextWithoutParam {

    @Test
    void checkTextOnEnglish() {
        new YandexSpellerAssertions().checkText(WRONG_WORD_ON_ENGLISH,
            RIGHT_WORD_ON_ENGLISH);
    }

    @Test
    void checkTextOnRussian() {
        new YandexSpellerAssertions().checkText(WRONG_WORD_ON_RUSSIAN,
            RIGHT_WORD_ON_RUSSIAN);
    }
}
