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
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User saveUser(@Valid UserDto userDto) {
        User user = new User();
        user.setSurname(userDto.getSurname());
        user.setAfm(userDto.getAfm());
        user.setAmka(userDto.getAmka());
        user.setUsername(userDto.getSurname());
        // encrypt the password using spring security

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName(userDto.getRole());
        if (role == null) {
            role = new Role();
            role.setName("ROLE_USER");
            role = roleRepository.save(role);
        }

        // Assign roles to the user
        user.setRoles(List.of(role));

        userRepository.save(user);
        return user;
    }

    @Override
    public User findUserBySurname(String surname) {

        return userRepository.findUserBySurname(surname);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public User addUser(UserDto userDto) {
        User user = new User();
        user.setSurname(userDto.getSurname());
        user.setAfm(userDto.getAfm());
        user.setAmka(userDto.getAmka());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUsername(userDto.getSurname());

        // Assign roles to the user
        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
        Role roleUser = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(roleAdmin, roleUser));

        // Save the user to the repository
        return userRepository.save(user);
    }


    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setSurname(user.getSurname());
        userDto.setAfm(user.getAfm());
        userDto.setAmka(user.getAmka());
        userDto.setRole(user.getRoles().toString());

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
