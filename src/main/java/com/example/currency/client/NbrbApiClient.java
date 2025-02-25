package com.example.currency.client;

import com.example.currency.dto.CurrencyInfo;
import com.example.currency.dto.CurrencyRate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class NbrbApiClient {

    private final RestTemplate restTemplate;
    private static final String API_BASE_URL = "https://api.nbrb.by/exrates/";

    public NbrbApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<CurrencyInfo> getAllCurrencies() {
        String url = API_BASE_URL + "currencies";
        ResponseEntity<CurrencyInfo[]> response = restTemplate.getForEntity(url, CurrencyInfo[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public CurrencyRate getCurrencyRate(Integer curId) {
        String url = API_BASE_URL + "rates/" + curId;
        return restTemplate.getForObject(url, CurrencyRate.class);
    }
}