package ua.lazin.vladyslav.eventify.domain;

import java.io.Serializable;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    Integer id;

    @Column(name = "nickname", nullable = false, unique = true)
    String nickname;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "pswd")
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "email_verified", nullable = false)
    @ColumnDefault("false")
    boolean isEmailVerified = false;  // Java-side default

    @Column(name = "phone_verified", nullable = false)
    @ColumnDefault("false")
    boolean isPhoneVerified = false;  // Java-side default

    @Column(name = "active", nullable = false)
    @ColumnDefault("true")
    boolean isActive = true;  // Java-side default

    // Uncomment and define these fields correctly when ready
    // @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    // @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "fk_user_id"))
    // @Enumerated(EnumType.STRING)
    // @ColumnDefault("'USER'")
    // Set<Role> roles;

    // Set<Event> favoriteEvents;
    // Set<Event> createdEvents;
    // Set<Course> createdCourses;
    // Set<Course> subscribedCourses;
}
