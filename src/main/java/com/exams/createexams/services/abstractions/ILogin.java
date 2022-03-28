package com.exams.createexams.services.abstractions;

import com.exams.createexams.exception.InvalidCredentialsException;
import com.exams.createexams.model.dtos.requests.AuthenticationRequest;
import com.exams.createexams.model.dtos.response.AuthenticationResponse;

public interface ILogin {

    AuthenticationResponse login(AuthenticationRequest authenticationRequest)
        throws InvalidCredentialsException;

}
