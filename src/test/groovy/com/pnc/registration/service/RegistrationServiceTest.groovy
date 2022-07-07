package com.pnc.registration.service

import com.pnc.registration.model.RegistrationRequestBody
import com.pnc.registration.model.RegistrationResponse
import com.pnc.registration.service.impl.RegistrationServiceImpl
import spock.lang.Specification

class RegistrationServiceTest extends Specification {

    RegistrationService registrationService

    def setup() {
        registrationService = new RegistrationServiceImpl()
    }

    def "getRegistration() || Successfully invoke registration service"() {
        given:
        RegistrationRequestBody registrationRequestBody = new RegistrationRequestBody("neeral", "Password123#", "24.48.0.1")

        when:
        RegistrationResponse result = registrationService.registration(registrationRequestBody)

        then:
        result != null
    }
}
