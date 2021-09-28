package com.epam.tc.hw9.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw9.dto.YandexSpellerDto;

public class YandexSpellerAssertions {

    public void checkTheCorrectWord(String text, String expected) {
        YandexSpellerDto[] correctWord = new YandexSpellerService().getCorrectWord(text);
        assertThat(correctWord[0].getS()).as("Parameter of right words not contains expected correct one")
                                         .contains(expected);
    }

    public void checkTheCorrectWorkWithLangParam(String text, String language, String expected) {
        YandexSpellerDto[] correctWord = new YandexSpellerService().getCorrectWordWithLanguageParam(text, language);
        assertThat(correctWord.length).as(
                                          "The checked word was correct "
                                              + "or the value of parameter \"lang\" was incorrect!")
                                      .isNotEqualTo(0);
        assertThat(correctWord[0]
            .getS()).as("The operation with this parameter isn't correct!")
                    .contains(expected);
    }

    public void checkTheCorrectWorkWithOptionsParam(String text, Integer options) {
        YandexSpellerDto[] correctWord = new YandexSpellerService().getCorrectWordWithOptionsParam(text, options);

        switch (options) {
            case 2:
                assertThat(correctWord.length).as(
                                                  "The operation with this parameter isn't correct!")
                                              .isEqualTo(0);
                break;
            case 8:
                assertThat(correctWord.length).as(
                                                  "The operation with this parameter isn't correct!")
                                              .isNotEqualTo(0);
                break;
            default:
                break;
        }
    }

    public YandexSpellerAssertions getStatus(String text) {
        assertThat(new CommonService().getWord(text).getStatusCode()).isEqualTo(200);
        return this;
    }
}
