package ua.lazin.vladyslav.eventify.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
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

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    Set<Role> roles;

    Set<Event> favoriteEvents;

    Set<Event> createdEvents;

    Set<Course> createdCourses;

    Set<Course> subscribedCourses;

}
