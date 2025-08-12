package com.tour_service.Tour_Package_Management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tour_service.Tour_Package_Management.entity.User;
import com.tour_service.Tour_Package_Management.repo.UserRepository;
import com.tour_service.Tour_Package_Management.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUsers(List<User> users) {
        try {
            users.stream().forEach(user -> {
                user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            });
            this.userRepository.saveAll(users);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = this.userRepository.findByUsername(username);
        UserDetailsImpl userImpl = users.map(user -> new UserDetailsImpl(user)).orElse(null);

        return userImpl;

    }

    @Override
    public void deleteAllUsers() {
        try {
            this.userRepository.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
