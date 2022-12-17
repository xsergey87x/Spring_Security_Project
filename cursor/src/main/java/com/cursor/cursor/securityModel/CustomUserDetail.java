package com.cursor.cursor.securityModel;

import com.cursor.cursor.model.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class CustomUserDetail implements UserDetails {

    private final String userName;
    private final String password;
    private final boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails getUserDetailsFromUser(UserEntity user) {

        return new org.springframework.security.core.userdetails.User(
                user.getName(), user.getPassword(), user.isActive(), true,true,true,
                new ArrayList<SimpleGrantedAuthority>());
    }

//    @Bean
//    public String get(){return "";}
}
