package com.epam.tc.hw8.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw8.dto.YandexSpellerDto;

public class YandexSpellerAssertions {

    public void checkTheCorrectWord(String text, String expected) {
        YandexSpellerDto[] correctWord = new YandexSpellerService().getCorrectWord(text);
        assertThat(correctWord[0].getS()).as("Parameter of right words not contains expected correct one")
                                         .contains(expected);
    }

    public void checkTheCorrectWorkWithLangParam(String text, String language) {
        YandexSpellerDto[] correctWord = new YandexSpellerService().getCorrectWordWithLanguageParam(text, language);
        assertThat(correctWord.length).as(
                                          "The checked word was correct "
                                              + "or the value of parameter \"lang\" was incorrect!")
                                      .isNotEqualTo(0);
        assertThat(correctWord[0]
            .getS()).as("The operation with this parameter isn't correct!"
                        + " The \"lang\" parameter has difference with checked word.")
                    .isNullOrEmpty();
    }

    public void checkTheCorrectWorkWithOptionsParam(String text, String options, String expected) {
        YandexSpellerDto[] correctWord = new YandexSpellerService().getCorrectWordWithOptionsParam(text, options);
        assertThat(correctWord.length).as(
                                          "The operation with this parameter isn't correct!"
                                              + "The value of parameter \"options\" was \"8\" and the repeating word should be displayed")
                                      .isNotEqualTo(0);
        assertThat(correctWord[0]
            .getS()).as("Parameter of right words not contains expected correct one")
                    .contains(expected);
    }

    public YandexSpellerAssertions getStatus(String text) {
        assertThat(new CommonService().getWord(text).getStatusCode()).isEqualTo(200);
        return this;
    }
}
