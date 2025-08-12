package com.tour_service.Tour_Package_Management.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.tour_service.Tour_Package_Management.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // role :- ADMIN, SELLER
        return Arrays.stream(StringUtils.tokenizeToStringArray(this.user.getRoles(), " "))
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList();
    }

}
