package ua.lazin.vladyslav.eventify.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.Data;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    long id;

    @Column(name = "user_name")
    String userName;

    String name;

    String surname;

    String email;

    String password;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "is_email_verified")
    boolean isEmailVerified;

    @Column(name = "is_phone_verified")
    boolean isPhoneVerified;

    Set<Role> roles;

    Set<Event> favoriteEvents;

    Set<Event> createdEvents;

    Set<Event> createdCourses;

}
