
/*
package com.project.mutualDivorce.Service;


import com.project.mutualDivorce.Dto.UserDtoOld;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Repository.UserRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceOld {
    private final UserRepositoryOld userRepository;

    @Autowired
    public UserServiceOld(UserRepositoryOld userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public void deleteById(long id){
        userRepository.deleteById(id);
    }
    public User addUser(UserDtoOld userFormDto){
        User userDto = new User();
        userDto.setSurname(userFormDto.getSurname());
        userDto.setAfm(userFormDto.getAfm());
        userDto.setAmka(userFormDto.getAmka());
        userDto.setPassword(userFormDto.getPassword());
        userDto.setRole(userFormDto.getRole());
        userDto.setId(userFormDto.getId());
        return userRepository.save(userDto);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}


 */