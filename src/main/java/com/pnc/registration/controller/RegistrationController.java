package com.pnc.registration.controller;

import com.pnc.registration.model.RegistrationRequestBody;
import com.pnc.registration.model.RegistrationResponse;
import com.pnc.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping(value = "/registration", produces = {"application/json"})
    public ResponseEntity<RegistrationResponse> getRegistration(@RequestBody RegistrationRequestBody registrationRequestBody) throws Exception {
        RegistrationResponse registrationResponse = registrationService.registration(registrationRequestBody);
        return ResponseEntity.accepted().body(registrationResponse);
    }

}
