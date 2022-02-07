package com.ceyloneagro.ceyloneagrobackendservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Value("${rest-template.default.time-out}")
    private int timeOut;

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder builder) {

        SimpleClientHttpRequestFactory simpleFactory = new SimpleClientHttpRequestFactory();
        simpleFactory.setOutputStreaming(false);
        simpleFactory.setConnectTimeout(timeOut);
        simpleFactory.setReadTimeout(timeOut);

        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(simpleFactory);
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        return restTemplate;
    }

}
