package com.softic.softa.services;

import com.softic.softa.entities.User;
import com.softic.softa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository)
    {
        this.repository=repository;
    }

    public User  CreateUser(User newUser){

        return this.repository.save(newUser);
    }

    public User findByEmail(String email){
        return this.repository.findByEmail(email);
    }
    public User getOrCreateUser (Map<String,Object> userData){

        String email= (String) userData.get("email");
        User user = findByEmail(email);

        if(user==null){

        String image = (String) userData.get("picture");
        String auth0id = (String) userData.get("sub");

        User newuser = new User(email=email,image=image, auth0id=auth0id);


        return CreateUser(newuser);
    }
        return user;

    }
}
