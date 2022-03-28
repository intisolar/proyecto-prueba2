package com.exams.createexams.mappers;

import com.exams.createexams.models.dtos.response.UserResponse;
import com.exams.createexams.models.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse map(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setFullName(user.getFirstName(), user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoto(user.getPhoto());
        userResponse.setRoles(user.getRoles());
        userResponse.setSoftDelete(user.isSoftDelete());
        return userResponse;
    }

    public List<UserResponse> map(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>(users.size());
        for (User user : users) {
            userResponses.add(map(user));
        }
        return userResponses;
    }

}
