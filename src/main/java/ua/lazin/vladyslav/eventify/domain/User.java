package ua.lazin.vladyslav.eventify.domain;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
`import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    Long id;

    @Column(name = "nickname", nullable = false, unique = true)
    String nickname;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "password")
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "email_verified")
    @ColumnDefault("false")
    boolean isEmailVerified;

    @Column(name = "phone_erified")
    @ColumnDefault("false")
    boolean isPhoneVerified;

    @Column(name = "active")
    @ColumnDefault("true")
    boolean isActive;

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
