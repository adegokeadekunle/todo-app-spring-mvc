package com.group5.activitytrackergroup5task.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "status")
    private String status;
    @Column(name = "description")
    private String description;
    @Column(name = "scheduled_on")
    private LocalDateTime scheduledOn;
    @Column(name = "end_on")
    private LocalDateTime endOn;




}
