package com.udomomo.springboottodo.domain.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="task")
@Getter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;
    private int urgency;
    private int importance;
    private boolean isDone;

    private TaskEntity() {};

    public TaskEntity(String content, Integer urgency, Integer importance) {
        this.isDone = false;
        if (validateContent(content) && validateUrgency(urgency) && validateImportance(importance)) {
            this.content = content;
            this.urgency = urgency;
            this.importance = importance;
        }
    }

    public TaskEntity(int id, String content, Integer urgency, Integer importance) {
        this.id = id;
        this.isDone = false;
        if (validateContent(content) && validateUrgency(urgency) && validateImportance(importance)) {
            this.content = content;
            this.urgency = urgency;
            this.importance = importance;
        }
    }

    private boolean validateContent(String content) {
        if (content.length() > 100) {
            throw new IllegalArgumentException("content is too long: " + content);
        }
        return true;
    }

    private boolean validateUrgency(Integer urgency) {
        if (!(Score.isValidScore(urgency))) {
            throw new IllegalArgumentException("invalid urgency value: " + urgency);
        }
        return true;
    }

    private boolean validateImportance(Integer importance) {
        if (!(Score.isValidScore(importance))) {
            throw new IllegalArgumentException("invalid urgency value: " + importance);
        }
        return true;
    }

    public void makeDone() {
        this.isDone = true;
    }

    public void makeUndone() {
        this.isDone = false;
    }
}
