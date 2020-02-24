package com.udomomo.springboottodo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String content;
    private int urgency;
    private int importance;
    private boolean isDone;

    public TaskEntity(String content, Integer urgency, Integer importance, boolean isDone) {
        this.content = content;
        this.urgency = urgency;
        this.importance = importance;
        this.isDone = isDone;
    }
}
