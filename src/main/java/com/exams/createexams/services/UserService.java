package com.exams.createexams.services;

import com.exams.createexams.common.JwtUtils;
import com.exams.createexams.exception.InvalidCredentialsException;
import com.exams.createexams.model.dtos.requests.AuthenticationRequest;
import com.exams.createexams.model.dtos.response.AuthenticationResponse;
import com.exams.createexams.model.entities.User;
import com.exams.createexams.repositories.IUserRepository;
import com.exams.createexams.services.abstractions.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, ILogin {

    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

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
}
