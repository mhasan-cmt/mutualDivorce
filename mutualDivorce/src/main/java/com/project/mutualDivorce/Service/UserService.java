package com.project.mutualDivorce.Service;

import com.project.mutualDivorce.Dto.UserDto;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
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
    public User createNewUser(UserDto userFormDto){
        User userDto = new User();
        userDto.setAfm(userFormDto.getAfm());
        userDto.setAmka(userFormDto.getAmka());
        userDto.setSurname(userFormDto.getSurname());
        userDto.setRole(userFormDto.getRole());
        userDto.setId(userFormDto.getId());
        return userRepository.save(userDto);
    }
}
