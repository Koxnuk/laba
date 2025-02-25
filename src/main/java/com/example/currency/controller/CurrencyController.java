package com.example.currency.controller;

import com.example.currency.dto.CurrencyInfo;
import com.example.currency.service.CurrencyConversionService;
import com.example.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final CurrencyConversionService conversionService;
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(
            CurrencyConversionService conversionService,
            CurrencyService currencyService
    ) {
        this.conversionService = conversionService;
        this.currencyService = currencyService;
    }

    @GetMapping("/convert")
    public ResponseEntity<?> convert(
            @RequestParam Integer from,
            @RequestParam Integer to,
            @RequestParam BigDecimal amount) {

        try {
            BigDecimal result = conversionService.convertCurrency(from, to, amount);
            return ResponseEntity.ok(Map.of(
                    "amount", amount,
                    "from", from,
                    "to", to,
                    "result", result
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "Conversion error: " + e.getMessage())
            );
        }
    }

    @GetMapping("/list")
    public List<CurrencyInfo> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }
}