package com.ilan.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MessageToMobile {

    @GetMapping(value = "/testM.brio",produces = MediaType.APPLICATION_JSON_VALUE)
    public  Object getTest(@RequestParam(value="phoneNo") String phoneNo)    {
        final String ENCODING = "UTF-8";

        RestTemplate restTemp=new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://pay4sms.in/sendsms/")
                .queryParam("token", "67242d7568e113b44b21d8beae8b0653")
                .queryParam("credit", 2)
                .queryParam("sender", "BTISRL")
                .queryParam("number", phoneNo);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        System.out.println("========+>>>"+(  builder.toUriString()+"&message="+"ILAN messaging APP test"  ));
        HttpEntity<String> response = restTemp.exchange( ( builder.toUriString()+"&message="+"BILL TEST MESSAGE FROM ILAN" ), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

}
