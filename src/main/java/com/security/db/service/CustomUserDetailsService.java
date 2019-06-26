package com.security.db.service;

import com.security.db.model.CustomUserDetails;
import com.security.db.model.Users;
import com.security.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = usersRepository.findByName(username);

        user.orElseThrow(()->new UsernameNotFoundException("Unable to find user"));

       return user.map(CustomUserDetails::new).get();





    }
}
