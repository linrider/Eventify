package ua.lazin.vladyslav.eventify.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Entity
@Data
@Table(name = "events")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    Long id;
    
    String title;

    String description;

    @Column(name = "event_time")
    LocalDateTime dateTime;

    @Column(name = "fk_course_id")
    Course course;

    @Column(name = "fk_creator_id")
    User creator;
}
