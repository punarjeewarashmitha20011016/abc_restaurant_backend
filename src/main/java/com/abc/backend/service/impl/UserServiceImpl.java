package com.abc.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.model.Restaurent;
import com.abc.backend.model.Role;
import com.abc.backend.model.User;
import com.abc.backend.repository.RoleRepository;
import com.abc.backend.repository.UserRepository;
import com.abc.backend.service.UserService;
import com.abc.backend.util.SequenceIdGen;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SequenceIdGen sequenceIdGen;

    public List<User> allUsers() {
        return userRepository.findAll();  
    }

    public User addUser(User user) {
        user.setId(sequenceIdGen.generateSequence(User.class.getSimpleName()));
        return userRepository.save(user); 
    }

    public Optional<User> singleUser(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> singleUserByEmailAndPassword(String email,String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setAddress(userDetails.getAddress());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    public User updatePassword(Long id, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(newPassword); // Update the password
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
            userRepository.deleteById(id);
    }

    public Long getCount() {
        return userRepository.count();
    }
    
    
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> singleRole(int roleID) {
        return roleRepository.findByRoleID(roleID);
    }

}
