package com.exams.createexams.models.dtos.response;

import com.exams.createexams.models.entities.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String fullName;

    private String photo;

    private String email;

    @JsonInclude(Include.NON_EMPTY)
    private List<Role> roles;

    private boolean softDelete;

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName+" "+lastName;
    }
}
