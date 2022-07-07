package com.pnc.registration.controller

import com.pnc.registration.model.RegistrationRequestBody
import com.pnc.registration.model.RegistrationResponse
import com.pnc.registration.service.RegistrationService
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class RegistrationControllerTest extends Specification {

    RegistrationController registrationController
    RegistrationService registrationService

    def setup() {
        registrationService = Mock()
        registrationController = new RegistrationController(registrationService)
    }

    def "getRegistration() | Successfully invoke get registration controller"() {
        given:
        //build out request and response body
        RegistrationResponse registrationResponse = new RegistrationResponse("Welcome neeral", "Montreal", "1a19f769-5a16-475d-b575-196c3725208c")
        RegistrationRequestBody registrationRequestBody = new RegistrationRequestBody("neeral", "Password123#", "24.48.0.1")

        registrationService.registration(registrationRequestBody) >> registrationResponse

        when:
        ResponseEntity<RegistrationResponse> result  = registrationController.getRegistration(registrationRequestBody)

        then:
        result != null

    }
}
