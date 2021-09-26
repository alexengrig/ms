package com.example.ms.sloth.rest.service;

import com.example.ms.sloth.rest.entity.SlothEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface SlothService {

    SlothEntity create(String id);

    List<SlothEntity> createAll(Iterable<String> ids);

    List<SlothEntity> getAll();

    LocalDateTime sleep(String id, long timeout);

}
