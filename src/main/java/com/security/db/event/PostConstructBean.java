package com.security.db.event;


import com.security.db.model.Role;
import com.security.db.model.Users;
import com.security.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostConstructBean {

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    public void init(){

        Role role1 = new Role();
        role1.setRole("ADMIN");


        Role role2 = new Role();
        role2.setRole("USER");

        Role role3 = new Role();
        role3.setRole("ENDUSER");


        Users user1 = new Users();
        user1.setEmail("shaswat.dasgupta@xyz.com");
        user1.setName("shaswat123");
        user1.setActive(1);
        user1.setLastName("DG");
        user1.setPassword("abc123");
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);

        usersRepository.save(user1);

        Users user2 = new Users();
        user2.setEmail("shaswat.d@ypd.com");
        user2.setName("sdg123");
        user2.setActive(1);
        user2.setLastName("SDG");
        user2.setPassword("abc1234");
        user2.getRoles().add(role3);

        usersRepository.save(user2);




    }
}
