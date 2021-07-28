package com.ilan.configuration;


import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@RefreshScope
@Configuration
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Data
public class TestRefreshConfiguration {

    @Value("${test.property}")
    private String name;


    @Bean
    @Qualifier("testString")
    String testString(){
        return name;
    }
}
