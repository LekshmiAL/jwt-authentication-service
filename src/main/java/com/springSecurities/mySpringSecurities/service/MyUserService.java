package com.springSecurities.mySpringSecurities.service;

import com.springSecurities.mySpringSecurities.model.UserAccount;
import com.springSecurities.mySpringSecurities.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Logic to get the user form the Database
       UserAccount u= repo.findByUsername(username);
        return new User(u.getUsername(),u.getPassword(),new ArrayList<>());

       /* filter incoming requests checking them for a
        valid jwt before the security context is set*/

    }
}
