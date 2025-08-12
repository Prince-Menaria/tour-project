package com.tour_service.Tour_Package_Management.service;

import java.util.List;

import com.tour_service.Tour_Package_Management.entity.User;

public interface UserService {

    public void saveUsers(List<User> user);

    public void deleteAllUsers();

}
