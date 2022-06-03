package org.jaywikstrom.golftracker.service;

import org.jaywikstrom.golftracker.model.User;
import org.jaywikstrom.golftracker.security.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}
