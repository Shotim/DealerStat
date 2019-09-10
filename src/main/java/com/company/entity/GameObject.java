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
public class GameObject {
    Integer id;
    String title;
    String text;
    Enum status;
    Date createdAt;
    Date updatedAt;
    Integer gameId;
}
