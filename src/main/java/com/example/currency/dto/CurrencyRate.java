package com.example.currency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CurrencyRate {
    @JsonProperty("Cur_ID")
    private Integer curId;

    @JsonProperty("Cur_OfficialRate")
    private BigDecimal curOfficialRate;

    @JsonProperty("Cur_Scale")
    private Integer curScale;

    @JsonProperty("Date")
    private String date;

    // Геттеры
    public Integer getCurId() { return curId; }
    public BigDecimal getCurOfficialRate() { return curOfficialRate; }
    public Integer getCurScale() { return curScale; }
    public String getDate() { return date; }
}