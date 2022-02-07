package com.ceyloneagro.ceyloneagrobackendservice.config;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());

    private long requestTime;
    private long responseTime;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        logInfo(request, response);
        return response;
    }

    private void logInfo(HttpRequest request, ClientHttpResponse response) throws IOException {
        if (!log.isDebugEnabled()) {
            log.info("================================= begin ================================================");
            log.info("Requested URI         : {}", request.getURI());
            log.info("Requested Method      : {}", request.getMethod());
            log.info("Response Status  : {}", response.getStatusCode());
            log.info("Response Time  : {} ms", (responseTime - requestTime));
            log.info("================================= end ================================================");
        }
    }

    private void logRequest(HttpRequest request, byte[] body) {
        requestTime = System.currentTimeMillis();
        log.debug("===========================request begin================================================");
        log.debug("URI         : {}", request.getURI());
        log.debug("Method      : {}", request.getMethod());
        log.debug("Headers     : {}", request.getHeaders());
        String requestBody = new String(body, StandardCharsets.UTF_8);
        log.debug("Request body: {}", requestBody);
        log.debug("==========================request end================================================");
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        responseTime = System.currentTimeMillis();
        log.debug("============================response begin==========================================");
        log.debug("Status code  : {}", response.getStatusCode());
        log.debug("Headers      : {}", response.getHeaders());
        String responseBody = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
        log.debug("Response body: {}", responseBody);
        log.debug("Response Time  : {} ms", (responseTime - requestTime));
        log.debug("=======================response end=================================================");
    }

}
