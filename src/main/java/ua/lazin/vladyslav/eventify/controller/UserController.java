package ua.lazin.vladyslav.eventify.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lazin.vladyslav.eventify.domain.User;
import ua.lazin.vladyslav.eventify.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        if (userService.addUser(user)) {
            LOGGER.info("User added");
        } else {
            LOGGER.info("User already exists");
            
        }
    }

}
