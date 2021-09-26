package com.example.ms.sloth.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "sloth not awake")
public class SlothNotAwakeException extends RuntimeException {

    public SlothNotAwakeException(String id, LocalDateTime wakeUpAt) {
        super("Sloth is not awake by id: " + id + ", and wakes up at " + wakeUpAt);
    }

}
