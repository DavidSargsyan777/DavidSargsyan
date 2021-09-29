package com.epam.tc.hw9.service;

import static com.epam.tc.hw9.utils.Codes.ERROR_REPEAT_WORD;
import static com.epam.tc.hw9.utils.Codes.ERROR_UNKNOWN_WORD;
import static com.epam.tc.hw9.utils.Options.FIND_REPEAT_WORDS;
import static com.epam.tc.hw9.utils.Options.IGNORE_DIGITS;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw9.dto.YandexSpellerResponseDto;

public class YandexSpellerAssertions {
    static final YandexSpellerService SPELLER_SERVICE_INSTANCE = YandexSpellerService.getInstance();

    public void checkText(String text, String expected) {
        YandexSpellerResponseDto[] correctWord = SPELLER_SERVICE_INSTANCE.getCheckText(text);
        assertThat(correctWord[0].getS()).as("Parameter \"s\"  not contains expected word")
                                         .contains(expected);
        assertThat(correctWord[0].getCode()).as("The code of Error isn't correct").isEqualTo(ERROR_UNKNOWN_WORD);
    }

    public void checkTextWithLangParam(String text, String language, String expected) {
        YandexSpellerResponseDto[] correctWord =
            SPELLER_SERVICE_INSTANCE.getCheckTextWithLanguageParam(text, language);
        assertThat(correctWord[0]
            .getS()).as("The operation with \"lang\" parameter isn't correct!")
                    .contains(expected);
    }

    public void checkTextWithOptionsThatIgnoreDigits(String text) {
        YandexSpellerResponseDto[] correctWord =
            SPELLER_SERVICE_INSTANCE.getCheckTextWithOptionsParam(text, IGNORE_DIGITS);
        assertThat(correctWord.length).as(
                                          "The operation with ignore digits isn't correct!")
                                      .isEqualTo(0);
    }

    public void checkTextWithOptionsThatFindRepeatWord(String text) {
        YandexSpellerResponseDto[] correctWord =
            SPELLER_SERVICE_INSTANCE.getCheckTextWithOptionsParam(text, FIND_REPEAT_WORDS);
        assertThat(correctWord.length).as(
                                          "The operation with find repeat words isn't correct!")
                                      .isNotEqualTo(0);
        assertThat(correctWord[0].getCode()).as("The code of Error must match 2").isEqualTo(ERROR_REPEAT_WORD);
    }
}
