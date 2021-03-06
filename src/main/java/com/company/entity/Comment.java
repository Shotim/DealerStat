package com.company.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Comment {
    public static final int DEFAULT_ID = 0;
    Integer id;
    String message;
    Integer postId;
    Integer authorId;
    Date createdAt;
    Boolean approved;
}
