package com.exams.createexams.services.abstractions;

import com.exams.createexams.models.dtos.response.ListUserResponse;

public interface IGetUserDetails {

    ListUserResponse findActiveUsers();

}
