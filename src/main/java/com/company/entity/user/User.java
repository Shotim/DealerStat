package com.company.entity.user;

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
    public static final int DEFAULT_ID = 0;
    Integer id;
    String firstName;
    String lastName;
    String password;
    String email;
    Date createdAt;
    Enum role;
}
