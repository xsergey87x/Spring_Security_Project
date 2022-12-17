package com.cursor.cursor.security;

import com.cursor.cursor.model.UserEntity;
import com.cursor.cursor.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class JwtUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserEntity user1 = new UserEntity("Artur","xxx@ukr.net","qwerty", "ROLE_ADMIN");
        UserEntity user2 = new UserEntity("John","yyy@ukr.net","ytrewq", "ROLE_USER");

        UserEntity user = userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userName));
         return new User(user.getUserName(),user.getPassword(), user.isActive(),true,true,true, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));

//        if ("Artur".equals(userName)){
//            return new User("Artur","qwerty", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
//        }else if ("John".equals(userName)) {
//            return new User("John","ytrewq", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
//        } else {throw new UsernameNotFoundException("User not found with username: " + userName); }

    }
}
