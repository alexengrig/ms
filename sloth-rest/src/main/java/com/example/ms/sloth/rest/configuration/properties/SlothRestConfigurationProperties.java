package com.example.ms.sloth.rest.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("sloth.rest")
public class SlothRestConfigurationProperties {
    private List<String> ids;
}
