package com.exams.createexams.services;

import com.exams.createexams.common.JwtUtils;
import com.exams.createexams.exception.InvalidCredentialsException;
import com.exams.createexams.mappers.UserMapper;
import com.exams.createexams.models.dtos.requests.AuthenticationRequest;
import com.exams.createexams.models.dtos.response.AuthenticationResponse;
import com.exams.createexams.models.dtos.response.ListUserResponse;
import com.exams.createexams.models.dtos.response.UserResponse;
import com.exams.createexams.models.entities.User;
import com.exams.createexams.repositories.IUserRepository;
import com.exams.createexams.services.abstractions.IGetUserDetails;
import com.exams.createexams.services.abstractions.ILogin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, ILogin, IGetUserDetails {

    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserMapper map;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser(username);
    }

    private User getUser(String username) {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return user;
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest)
        throws InvalidCredentialsException {
        User user = userRepository.findByEmail(authenticationRequest.getEmail());
        if (user == null) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                authenticationRequest.getPassword()));

        return new AuthenticationResponse(user.getEmail(), jwtUtil.generateToken(user));
    }


    private ListUserResponse buildListResponse(List<User> users) {
        List<UserResponse> userResponses = map.map(users);
        ListUserResponse listUserResponse = new ListUserResponse();
        listUserResponse.setUserResponses(userResponses);
        return listUserResponse;
    }

    @Override
    public ListUserResponse findActiveUsers() {
        List<User> users = userRepository.findBySoftDeleteFalseOrderByFirstName();
        return buildListResponse(users);
    }
}
