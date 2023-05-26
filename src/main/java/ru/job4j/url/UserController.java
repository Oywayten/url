package ru.job4j.url;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Oywayten 26.05.2023.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserStore users;
    private final BCryptPasswordEncoder encoder;

    public UserController(UserStore users,
                          BCryptPasswordEncoder encoder) {
        this.users = users;
        this.encoder = encoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
        users.save(person);
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return users.findAll();
    }
}