package com.company.entity.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class User {
    public static final int DEFAULT_ID = 0;
    Integer id;
    String firstName;
    String lastName;
    String password;
    String confirmPassword;
    String email;
    Date createdAt;
    Enum role;

    public User(Integer id, String firstName, String lastName, String password, String email, Date createdAt, Enum role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.createdAt = createdAt;
        this.role = role;
    }
}
