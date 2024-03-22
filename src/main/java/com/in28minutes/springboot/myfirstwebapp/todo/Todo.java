package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    @Size(min = 10, message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo(final int id,
                final String userName,
                final String description,
                final LocalDate targetDate,
                final boolean done) {
        super();
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Todo() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(final LocalDate targetDate) {
        this.targetDate = targetDate;
    }


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", description='" + description + '\'' +
            ", targetDate=" + targetDate +
            ", done=" + done +
            '}';
    }

}
