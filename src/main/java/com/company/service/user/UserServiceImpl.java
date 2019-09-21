package com.company.service.user;

import com.company.database.UserRepository;
import com.company.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    
    public UserRepository userRepository;
    
    @Override
    public List<User> findAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User findUser(int userId) {
        return userRepository.getUser(userId);
    }

    @Override
    public User findUser(String email) {
        return userRepository.getUser(email);
    }
















    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }





    @Override
    public void removeUser(int userId) {
        userRepository.deleteUser(userId);
    }



    @Override
    public void editUser(User user) {
        userRepository.editUser(user);
    }


}
