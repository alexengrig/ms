package com.example.ms.sloth.rest.service;

import com.example.ms.sloth.rest.entity.SlothEntity;
import com.example.ms.sloth.rest.exception.SlothNotAwakeException;
import com.example.ms.sloth.rest.exception.SlothNotFoundException;
import com.example.ms.sloth.rest.repository.SlothRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleSlothService implements SlothService {

    private final SlothRepository repository;

    @Override
    public SlothEntity create(String id) {
        SlothEntity entity = new SlothEntity(id, null);
        return repository.save(entity);
    }

    @Override
    public List<SlothEntity> createAll(Iterable<String> ids) {
        List<SlothEntity> entities = StreamSupport.stream(ids.spliterator(), false)
                .map(id -> new SlothEntity(id, null))
                .collect(Collectors.toList());
        return repository.saveAll(entities);
    }

    @Override
    public List<SlothEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public LocalDateTime sleep(String id, long timeout) {
        SlothEntity entity = repository.findById(id).orElseThrow(() -> new SlothNotFoundException(id));
        requireAwake(entity);
        LocalDateTime wakeUpAt = LocalDateTime.now().plus(timeout, ChronoUnit.MILLIS);
        SlothEntity updatedEntity = entity.withAwakenedAt(wakeUpAt);
        repository.save(updatedEntity);
        return wakeUpAt;
    }

    private void requireAwake(SlothEntity entity) {
        LocalDateTime awakenedAt = entity.getAwakenedAt();
        if (awakenedAt != null && LocalDateTime.now().isBefore(awakenedAt)) {
            throw new SlothNotAwakeException(entity.getId(), awakenedAt);
        }
    }

}
