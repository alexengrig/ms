package dev.alexengrig.ms.sloth.rest.controller;

import dev.alexengrig.ms.sloth.rest.service.SlothService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sloths")
@RequiredArgsConstructor
public class SlothController {

    private final SlothService service;

    @GetMapping
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/{id}/sleep")
    public ResponseEntity<?> sleep(@PathVariable String id, @RequestParam("timeout") long timeout) {
        return ResponseEntity.ok(service.sleep(id, timeout));
    }

}
