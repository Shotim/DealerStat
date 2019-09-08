package com.company.modules;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


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
