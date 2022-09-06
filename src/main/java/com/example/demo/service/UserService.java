package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional //todo check
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }

    public boolean existsByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

    public boolean existsByEmail(String userEmail) {
        return userRepository.existsByEmail(userEmail);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
