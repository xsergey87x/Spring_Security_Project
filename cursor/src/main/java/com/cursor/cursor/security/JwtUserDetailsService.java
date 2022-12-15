package com.cursor.cursor.security;

import com.cursor.cursor.model.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserEntity user1 = new UserEntity("Artur","xxx@ukr.net","qwerty", "ROLE_ADMIN");
        UserEntity user2 = new UserEntity("John","yyy@ukr.net","ytrewq", "ROLE_USER");

        if ("Artur".equals(userName))
        {
            return new User("Artur","qwerty", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }else if ("John".equals(userName))
        {
            return new User("John","ytrewq", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        }
 else {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
    }
}
