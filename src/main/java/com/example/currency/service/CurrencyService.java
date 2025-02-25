package com.example.currency.service;

import com.example.currency.client.NbrbApiClient;
import com.example.currency.dto.CurrencyInfo;
import com.example.currency.dto.CurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final NbrbApiClient nbrbApiClient;

    @Autowired
    public CurrencyService(NbrbApiClient nbrbApiClient) {
        this.nbrbApiClient = nbrbApiClient;
    }

    public List<CurrencyInfo> getAllCurrencies() {
        return nbrbApiClient.getAllCurrencies();
    }

    @Cacheable("currencyRates")
    public CurrencyRate getCurrencyRate(Integer curId) {
        return nbrbApiClient.getCurrencyRate(curId);
    }
}