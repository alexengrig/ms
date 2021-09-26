package com.example.ms.sloth.rest.listener;

import com.example.ms.sloth.rest.configuration.properties.SlothRestConfigurationProperties;
import com.example.ms.sloth.rest.service.SlothService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SlothCreatorListener implements ApplicationListener<ApplicationReadyEvent> {

    private final SlothRestConfigurationProperties properties;
    private final SlothService service;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        service.createAll(properties.getIds());
    }

}
