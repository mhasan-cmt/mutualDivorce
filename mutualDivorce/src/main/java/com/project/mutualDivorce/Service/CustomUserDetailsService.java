package com.project.mutualDivorce.Service;

import com.project.mutualDivorce.Entity.Role;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    /*
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String surname) throws UsernameNotFoundException {
        User user = userRepository.findUserBySurname(surname);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getSurname(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));

        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }


    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}


     */
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String surName) throws UsernameNotFoundException {
        User user = userRepository.findUserBySurname(surName);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}