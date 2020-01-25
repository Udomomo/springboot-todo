package com.udomomo.springboottodo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="task")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private final String content;
    private final int urgency;
    private final int importance;
    private final boolean isDone;
}
