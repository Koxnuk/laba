package com.example.currency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyInfo {
    @JsonProperty("Cur_ID")
    private Integer curId;

    @JsonProperty("Cur_Code")
    private String curCode;

    @JsonProperty("Cur_Abbreviation")
    private String curAbbreviation;

    @JsonProperty("Cur_Name")
    private String curName;

    @JsonProperty("Cur_Scale")
    private Integer curScale;
}