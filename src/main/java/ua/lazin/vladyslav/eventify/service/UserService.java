package ua.lazin.vladyslav.eventify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ua.lazin.vladyslav.eventify.domain.User;
import ua.lazin.vladyslav.eventify.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(User user) {
        boolean userFlag = true;
        Optional<User> usersFromDb = userRepository.findByNickname(user.getNickname());
        if (usersFromDb.isPresent()) {
            userFlag = false;
        } else {
            userRepository.save(user);
            userFlag = true;
        }
        return userFlag;
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

}
