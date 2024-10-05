package ua.lazin.vladyslav.eventify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lazin.vladyslav.eventify.domain.User;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByNickname(String nickname);

    void deleteByNickname(String nickname);
    
} 
