package ua.lazin.vladyslav.eventify.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lazin.vladyslav.eventify.domain.User;
import ua.lazin.vladyslav.eventify.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the unprotected area!";
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User getAppById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User addUser(@RequestBody User user) {
        if (userService.addUser(user)) {
            LOGGER.info("User added");
        } else {
            LOGGER.info("User already exists");
            
        }
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        boolean isSuccessfull = userService.updateUser(user);
        LOGGER.info("User updated: " + isSuccessfull);
        return user;
    }

}
