package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(++todoCount, "in28Minutes", "learn AWS 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "in28Minutes", "learn Devops 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "in28Minutes", "learn FullStack 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "in28Minutes", "learn CyberSecurity 1", LocalDate.now().plusYears(1), false));


    }

    public List<Todo> findByUserName(String userName) {
        Predicate<? super Todo> predicate = todo -> todo.getUserName().equalsIgnoreCase(userName);

        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String userName, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todoCount, userName, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);

    }

    public Todo findById(final int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;

        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(final Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
