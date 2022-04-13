package com.group5.activitytrackergroup5task.repositories;


import com.group5.activitytrackergroup5task.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
