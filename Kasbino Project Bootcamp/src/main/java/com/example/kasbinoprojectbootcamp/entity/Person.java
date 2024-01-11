package com.example.kasbinoprojectbootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person implements Serializable {
    private Long id;
    private String name;
    private String family;

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }
}
