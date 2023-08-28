package com.project.mutualDivorce.Service;

import com.project.mutualDivorce.Dto.UserDto;
import com.project.mutualDivorce.Entity.Role;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Repository.RoleRepository;
import com.project.mutualDivorce.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void saveUser(@Valid UserDto userDto) {
        User user = new User();
        user.setSurname(userDto.getSurname());
        user.setAfm(userDto.getAfm());
        user.setAmka(userDto.getAmka());
        user.setPassword(userDto.getPassword());
        user.setId(userDto.getId());
        user.setUsername(userDto.getSurname());
        // encrypt the password using spring security

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleAdmin = roleRepository.save(roleAdmin);
        }

        Role roleUser = roleRepository.findByName("ROLE_USER");
        if (roleUser == null) {
            roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleUser = roleRepository.save(roleUser);
        }

        // Assign roles to the user
        user.setRoles(Arrays.asList(roleAdmin, roleUser));

        userRepository.save(user);
    }

    @Override
    public User findUserBySurname(String surname) {

        return userRepository.findUserBySurname(surname);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {


    }


    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public User addUser(UserDto userDto) {
        return null;
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setSurname(userDto.getSurname());
        userDto.setAfm(user.getAfm());
        userDto.setAmka(user.getAmka());

        return userDto;
    }
    private Role checkRoleAdminExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");

        return roleRepository.save(role);
    }
    private Role checkRoleUserExist(){
        Role role = new Role();
        role.setName("ROLE_USER");

        return roleRepository.save(role);

}
    }
