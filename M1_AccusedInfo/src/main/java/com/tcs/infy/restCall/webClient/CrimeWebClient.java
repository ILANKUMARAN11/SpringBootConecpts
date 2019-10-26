package com.tcs.infy.restCall.webClient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Service
public class CrimeWebClient {

    WebClient client1 = WebClient.create();

    WebClient client2 = WebClient.create("http://MicroServiceTwo");

    WebClient client3 = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "http://MicroServiceTwo"))
            .build();



}
