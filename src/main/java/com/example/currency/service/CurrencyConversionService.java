package com.example.currency.service;

import com.example.currency.dto.CurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyConversionService {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyConversionService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public BigDecimal convertCurrency(Integer fromCurId, Integer toCurId, BigDecimal amount) {
        CurrencyRate fromRate = currencyService.getCurrencyRate(fromCurId);
        CurrencyRate toRate = currencyService.getCurrencyRate(toCurId);

        BigDecimal fromRatePerUnit = fromRate.getCurOfficialRate()
                .divide(BigDecimal.valueOf(fromRate.getCurScale()), 6, RoundingMode.HALF_UP);

        BigDecimal toRatePerUnit = toRate.getCurOfficialRate()
                .divide(BigDecimal.valueOf(toRate.getCurScale()), 6, RoundingMode.HALF_UP);

        return amount.multiply(fromRatePerUnit)
                .divide(toRatePerUnit, 2, RoundingMode.HALF_UP);
    }
}