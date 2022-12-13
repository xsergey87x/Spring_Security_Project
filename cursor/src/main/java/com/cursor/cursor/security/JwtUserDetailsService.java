package com.cursor.cursor.security;

import com.cursor.cursor.model.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collections;

public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user1 = new UserEntity("Artur","xxx@ukr.net","qwerty", "ROLE_ADMIN");
        UserEntity user2 = new UserEntity("John","yyy@ukr.net","ytrewq", "ROLE_USER");

        if ("xxx@ukr.net".equals(email))
        {
            return new User("Artur","pasword", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }else if ("yyy@ukr.net".equals(email))
        {
            return new User("John","pasword2", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        }
 else {
            throw new UsernameNotFoundException("User not found with username: " + email);
        }
    }
}
