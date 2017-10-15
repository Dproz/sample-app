package com.ceitechs.dproz.shared.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.ceitechs.dproz")
public class FeignConfiguration {

}
