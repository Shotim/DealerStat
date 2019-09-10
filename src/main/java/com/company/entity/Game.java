package com.company.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Game {
    Integer id;
    String name;
}
