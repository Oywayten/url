package ru.job4j.url;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Oywayten 26.05.2023.
 */
@Component
public class UserStore {
    private final ConcurrentHashMap<String, Person> users = new ConcurrentHashMap<>();

    public void save(Person person) {
        users.put(person.getUsername(), person);
    }


    public Person findByUsername(String username) {
        return users.get(username);
    }

    public List<Person> findAll() {
        return new ArrayList<>(users.values());
    }
}