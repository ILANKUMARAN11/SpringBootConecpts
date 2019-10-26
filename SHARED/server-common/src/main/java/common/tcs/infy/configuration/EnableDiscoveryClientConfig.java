package common.tcs.infy.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(name="enable-microService",havingValue = "true")
@Configuration
@EnableDiscoveryClient
public class EnableDiscoveryClientConfig
{
}
