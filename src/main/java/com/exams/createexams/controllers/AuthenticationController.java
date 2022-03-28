package com.exams.createexams.controllers;

import com.exams.createexams.exception.InvalidCredentialsException;
import com.exams.createexams.model.dtos.requests.AuthenticationRequest;
import com.exams.createexams.model.dtos.response.AuthenticationResponse;
import com.exams.createexams.services.abstractions.ILogin;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private ILogin login;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
        @RequestBody @Valid AuthenticationRequest authenticationRequest) throws
        InvalidCredentialsException {
        return ResponseEntity.ok(login.login(authenticationRequest));
    }

}
