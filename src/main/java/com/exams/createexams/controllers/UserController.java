package com.exams.createexams.controllers;

import com.exams.createexams.models.dtos.response.ListUserResponse;
import com.exams.createexams.services.abstractions.IGetUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IGetUserDetails getUserDetails;

    @GetMapping()
    public ResponseEntity<ListUserResponse> list() {
        return ResponseEntity.ok().body(getUserDetails.findActiveUsers());
    }
}
