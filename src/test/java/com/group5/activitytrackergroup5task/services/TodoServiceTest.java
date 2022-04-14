package com.group5.activitytrackergroup5task.services;

import com.group5.activitytrackergroup5task.models.Todo;
import com.group5.activitytrackergroup5task.repositories.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        Todo todo = Todo.builder()
                .id(1L)
                .title("work out")
                .status("Completed")
                .description("daily workout")
                .scheduledOn(LocalDateTime.now())
                .endOn(LocalDateTime.now())
                .build();

        Mockito.when(todoRepository.findById(1L)).thenReturn(Optional.ofNullable(todo));

    }
//    Id
//    title
//    status
//    description
//    scheduledon
//    endOn

    @Test
    public void shouldShowIfTodoIsFound(){

        Long todoId = 1L;
        Todo found = todoService.getTodo(todoId);

        assertEquals(todoId,found.getId());
    }

    @Test
    public void shouldSaveTodo(){
       Todo todo = new Todo();
       todo.setId(2L);
       todo.setTitle("studies");
       todo.setStatus("Completed");
       todo.setDescription("daily studies");
       todo.setScheduledOn(LocalDateTime.now());
       todo.setEndOn(LocalDateTime.now());

       todoRepository.save(todo);

        assertTrue( todo.getId().longValue() == 2L);

    }

    @Test
    public boolean shouldDeleteTodo(){
//        Todo todo = new Todo();
//        todo.setId(2L);
//        todo.setTitle("studies");
//        todo.setStatus("Completed");
//        todo.setDescription("daily studies");
//        todo.setScheduledOn(LocalDateTime.now());
//        todo.setEndOn(LocalDateTime.now());
//
//        todoRepository.save(todo);


        Long todoId = 1L;
        boolean deleted = false;
        Optional<Todo> todo = todoRepository.findById(1L);

        if (todo.isPresent()) {
            todoRepository.delete(todo.get());
            deleted = true;
        }
        return deleted;



    }

}

/*
 @Test
    void getTodoList() {
    }
    @Test
    void getTodo() {
    }
    @Test
    void saveTodo() {
    }
    @Test
    void deleteTodo() {
    }
 */