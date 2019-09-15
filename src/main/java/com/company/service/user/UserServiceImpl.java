package com.company.service.user;

import com.company.database.DataBaseService;
import com.company.entity.gameObject.GameObject;
import com.company.entity.Post;
import com.company.entity.Comment;
import com.company.entity.Game;
import com.company.entity.user.User;
import com.company.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    public DataBaseService dataBaseService;




    @Override
    public List<User> findAllUsers() {
        return dataBaseService.getAllUsers();
    }

    @Override
    public User findUser(int userId) {
        return dataBaseService.getUser(userId);
    }

    @Override
    public User findUser(String email) {
        return dataBaseService.getUser(email);
    }
















    @Override
    public void addUser(User user) {
        dataBaseService.addUser(user);
    }





    @Override
    public void removeUser(int userId) {
        dataBaseService.deleteUser(userId);
    }



    @Override
    public void editUser(User user) {
        dataBaseService.editUser(user);
    }


}
