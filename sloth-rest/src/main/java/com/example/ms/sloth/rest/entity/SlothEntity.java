package com.example.ms.sloth.rest.entity;

import com.example.ms.sloth.rest.configuration.RedisConfiguration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@RedisHash(RedisConfiguration.SLOTH_KEY)
public class SlothEntity {

    @Id
    private final String id;
    @With
    private final LocalDateTime awakenedAt;

}
