package com.group5.activitytrackergroup5task.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Person {
    @Id
    private Long id;
    @OneToMany
    List<Todo> todos;
}
