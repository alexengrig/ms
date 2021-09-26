package com.example.ms.sloth.rest.configuration;

import com.example.ms.sloth.rest.configuration.properties.SlothRestConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SlothRestConfigurationProperties.class)
public class SlothRestConfiguration {
}
