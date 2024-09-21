package ua.lazin.vladyslav.eventify.service;

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
        User userFromDb = (User) userRepository.findByNickname(user.getNickname());
        if (userFromDb != null) {
            userFlag = false;
        } else {
            userRepository.save(user);
            userFlag = true;
        }
        return userFlag;
    }

}
