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

    /*
    curl -H "Content-Type: application/json" -X POST -d {"""username""":"""admin""","""password""":"""password"""} "localhost:8080/users/sign-up"

    curl -i -H "Content-Type: application/json" -X POST -d {"""username""":"""admin""","""password""":"""password"""} "localhost:8080/login"
     */
    @PostMapping("/sign-up")
    public void signUp(@RequestBody Person person) {
        person.setPassword(encoder.encode(person.getPassword()));
        users.save(person);
    }

    /*
    curl -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY4NTk1OTU5NX0.eEjz1cO90mvwDPFgfPrJ7UWjm4fvzTb7gWi9DwoStHDl5wIHFuJ-HQyuvskAletwWl2wU-HAmj_mpOULfAvm2w" http://localhost:8080/users/all
     */
    @GetMapping("/all")
    public List<Person> findAll() {
        return users.findAll();
    }
}