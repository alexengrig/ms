package dev.alexengrig.ms.sloth.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "sloth not found")
public class SlothNotFoundException extends RuntimeException {

    public SlothNotFoundException(String id) {
        super("Sloth is not found by id: " + id);
    }

}
