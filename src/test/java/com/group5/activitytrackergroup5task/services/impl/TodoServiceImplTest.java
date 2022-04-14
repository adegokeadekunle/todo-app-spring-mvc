package com.group5.activitytrackergroup5task.services.impl;

import com.group5.activitytrackergroup5task.models.Todo;
import com.group5.activitytrackergroup5task.repositories.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ContextConfiguration(classes = {TodoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TodoServiceImplTest {

    @MockBean
    private TodoRepository todoRepository;

    @Autowired
    private TodoServiceImpl todoServiceImpl;


    @Test
    void shouldGetTodoListFromListOfTodos() {
        ArrayList<Todo> todoList = new ArrayList<>();
        when(this.todoRepository.findAll()).thenReturn(todoList);
        List<Todo> actualTodoList = this.todoServiceImpl.getTodoList();
        assertSame(todoList, actualTodoList);
        assertTrue(actualTodoList.isEmpty());
        verify(this.todoRepository).findAll();
    }


    @Test
    void shouldFindTodoById() {
        Todo todo = new Todo();
        todo.setDescription("The characteristics of someone or something");
        todo.setEndOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo.setId(123L);
        todo.setScheduledOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo.setTitle("Dr");
        Optional<Todo> ofResult = Optional.of(todo);
        when(this.todoRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(todo, this.todoServiceImpl.getTodo(123L));
        verify(this.todoRepository).findById((Long) any());
    }


    @Test
    void shouldSaveANewTodo() {
        Todo todo = new Todo();
        todo.setDescription("The characteristics of someone or something");
        todo.setEndOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo.setId(123L);
        todo.setScheduledOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo.setTitle("Dr");
        when(this.todoRepository.save((Todo) any())).thenReturn(todo);

        Todo todo1 = new Todo();
        todo1.setDescription("The characteristics of someone or something");
        todo1.setEndOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo1.setId(123L);
        todo1.setScheduledOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo1.setTitle("Dr");
        assertSame(todo, this.todoServiceImpl.saveTodo(todo1));
        verify(this.todoRepository).save((Todo) any());
    }

    @Test
    void shouldDeleteTodoById() {
        Todo todo = new Todo();
        todo.setDescription("The characteristics of someone or something");
        todo.setEndOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo.setId(123L);
        todo.setScheduledOn(LocalDateTime.of(1, 1, 1, 1, 1));
        todo.setTitle("Dr");
        Optional<Todo> ofResult = Optional.of(todo);
        doNothing().when(this.todoRepository).delete((Todo) any());
        when(this.todoRepository.findById((Long) any())).thenReturn(ofResult);
        assertTrue(this.todoServiceImpl.deleteTodo(123L));
        verify(this.todoRepository).findById((Long) any());
        verify(this.todoRepository).delete((Todo) any());
    }


}