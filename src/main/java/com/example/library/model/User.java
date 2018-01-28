package com.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean hasLicence;
}
