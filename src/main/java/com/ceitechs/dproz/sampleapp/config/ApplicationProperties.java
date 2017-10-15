package com.ceitechs.dproz.sampleapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to sampleapp.
 * <p>
 * Properties are configured in the application.yml file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

}
