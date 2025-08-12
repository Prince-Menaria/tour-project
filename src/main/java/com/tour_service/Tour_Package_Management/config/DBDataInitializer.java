package com.tour_service.Tour_Package_Management.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tour_service.Tour_Package_Management.service.UserService;
import com.tour_service.Tour_Package_Management.entity.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DBDataInitializer implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new LinkedList<>();
        User admin = new User();
        this.userService.deleteAllUsers(); // Clear existing users

        admin.setUsername("admin");
        admin.setPassword("admin123");
        admin.setRoles("ADMIN");

        User seller = new User();
        seller.setUsername("seller");
        seller.setPassword("seller123");
        seller.setRoles("SELLER");

        User buyer = new User();
        buyer.setUsername("buyer");
        buyer.setPassword("buyer123");
        buyer.setRoles("BUYER");

        users.add(admin);
        users.add(seller);
        users.add(buyer);

        userService.saveUsers(users);

    }

}
