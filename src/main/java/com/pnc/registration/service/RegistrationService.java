package com.pnc.registration.service;

import com.pnc.registration.model.RegistrationRequestBody;
import com.pnc.registration.model.RegistrationResponse;

public interface RegistrationService {

    RegistrationResponse registration(RegistrationRequestBody registrationRequestBody) throws Exception;

}
