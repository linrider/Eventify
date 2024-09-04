package ua.lazin.vladyslav.eventify.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    long id;
    
    String title;

    String description;

    LocalDate date;

    Course course;

    User creator;
}
