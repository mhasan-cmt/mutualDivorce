package com.project.mutualDivorce.Service;

import com.project.mutualDivorce.Dto.UserDto;

import com.project.mutualDivorce.Entity.User;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(@Valid UserDto userDto);

    User findUserBySurname(String Surname);

   // User findUserByEmail(String email);

    List<UserDto> findAllUsers();

    Optional<User> findById(long id);


    void deleteById(long id);


    Optional<User> findByUsername(String username);

    User addUser(UserDto userDto);
}
