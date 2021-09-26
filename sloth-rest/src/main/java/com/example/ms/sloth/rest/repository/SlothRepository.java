package com.example.ms.sloth.rest.repository;

import com.example.ms.sloth.rest.entity.SlothEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface SlothRepository extends Repository<SlothEntity, String> {

    List<SlothEntity> findAll();

    Optional<SlothEntity> findById(String id);

    SlothEntity save(SlothEntity sloth);

    List<SlothEntity> saveAll(Iterable<SlothEntity> sloths);

}
