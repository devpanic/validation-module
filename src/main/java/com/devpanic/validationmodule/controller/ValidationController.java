package com.devpanic.validationmodule.controller;

import com.devpanic.validationmodule.record.TestRecord;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {
    @PostMapping("/test")
    public ResponseEntity<?> beanValidTest(@RequestBody @Valid TestRecord testRecord) {
        return ResponseEntity.ok(testRecord);
    }
}
