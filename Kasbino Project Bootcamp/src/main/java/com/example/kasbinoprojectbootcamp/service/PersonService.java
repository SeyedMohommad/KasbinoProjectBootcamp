package com.example.kasbinoprojectbootcamp.service;

import com.example.kasbinoprojectbootcamp.entity.Person;
import com.example.kasbinoprojectbootcamp.repository.PersonDA;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PersonService {

    private static final PersonService PERSON_SERVICE = new PersonService();

    public static PersonService getPersonService() {
        return PERSON_SERVICE;
    }

    public void save(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.insert(person);
        }
    }


}
