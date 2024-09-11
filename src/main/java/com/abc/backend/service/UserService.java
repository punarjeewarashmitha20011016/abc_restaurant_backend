package com.abc.backend.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.abc.backend.model.Role;
import com.abc.backend.model.User;

public interface UserService {

    public List<User> allUsers();

    public User addUser(User user);

    public Optional<User> singleUser(ObjectId id);

    public Optional<User> singleUserByEmailAndPassword(String email,String password);

    public User updateUser(ObjectId id, User userDetails);

    public User updatePassword(ObjectId id, String newPassword);

    public void deleteUser(ObjectId id);
    public ObjectId getCount();
    
    public List<Role> allRoles();

    public Optional<Role> singleRole(int roleID);
}
