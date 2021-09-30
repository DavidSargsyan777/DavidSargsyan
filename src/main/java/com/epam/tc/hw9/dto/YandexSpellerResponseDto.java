package com.epam.tc.hw9.dto;

import lombok.Data;

@Data
public class YandexSpellerResponseDto {
    private Integer code;
    private Integer pos;
    private Integer row;
    private Integer col;
    private Integer len;
    private String word;
    private String[] s;
}
