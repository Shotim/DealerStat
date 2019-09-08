package com.company.modules;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Comment {
    Integer id;
    String message;
    Integer postId;
    Integer authorId;
    Date createdAt;
    Boolean approved;
}
