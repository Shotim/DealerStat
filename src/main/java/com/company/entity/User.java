package com.company.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String firstName;
    String lastName;
    String password;
    String email;
    Date createdAt;
    Enum role;

    public void createComment() {
        //TODO
    }

    public void findPost() {
        //TODO
    }

    public void findGameObject() {
        //TODO
    }

    public void findDealer() {
        //TODO
    }
}
