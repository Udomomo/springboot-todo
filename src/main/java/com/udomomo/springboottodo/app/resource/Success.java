package com.udomomo.springboottodo.app.resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Success {
    private Integer code;
    private String message;
}
