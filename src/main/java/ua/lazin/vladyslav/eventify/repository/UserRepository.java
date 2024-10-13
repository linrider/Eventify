package ua.lazin.vladyslav.eventify.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.lazin.vladyslav.eventify.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByNickname(String nickname);

    Optional<User> findById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.nickname = :nickname, " +
            "u.firstName = :firstname, " + 
            "u.lastName = :lastname, " + 
            "u.email = :email, " + 
            "u.phoneNumber = :phone_number, " + 
            "u.password = :password " + 
            "WHERE u.id = :id")
    int update(@Param("id") Integer id,
                     @Param("nickname") String nickname,
                     @Param("firstname") String firstName,
                     @Param("lastname") String lastName,
                     @Param("email") String email,
                     @Param("phone_number") String phoneNumber,
                     @Param("password") String password);

    void deleteByNickname(String nickname);

} 
