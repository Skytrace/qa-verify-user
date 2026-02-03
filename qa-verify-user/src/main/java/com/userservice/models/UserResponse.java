package com.userservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class UserResponse {
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String password;
    private Long id;
    private String createdAt;
}
