package com.group5.activitytrackergroup5task.services;


import com.group5.activitytrackergroup5task.models.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getTodoList();

    Todo getTodo(Long id);

    Todo saveTodo(Todo todo);

    boolean deleteTodo(Long id);
}