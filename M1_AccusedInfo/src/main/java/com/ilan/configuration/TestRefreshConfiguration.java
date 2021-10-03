package com.ilan.configuration;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@Data
public class TestRefreshConfiguration {

    @Value("${test.property:null}")
    private String name;

}
