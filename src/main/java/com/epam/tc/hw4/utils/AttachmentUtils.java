package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {
    @Attachment(type = "image/png", value = "failed test")
    public byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
